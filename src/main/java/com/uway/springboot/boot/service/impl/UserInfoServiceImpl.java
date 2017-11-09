package com.uway.springboot.boot.service.impl;

import com.uway.springboot.boot.dao.UserInfoRepository;
import com.uway.springboot.boot.entity.Permission;
import com.uway.springboot.boot.entity.Role;
import com.uway.springboot.boot.entity.UserInfo;
import com.uway.springboot.boot.service.UserInfoService;
import java.util.List;
import javax.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * Created by uwayxs on 2017/11/7.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    @Override
    public List<UserInfo> findRoleInfo(Long uid) {
        Specification<UserInfo> specification = new Specification<UserInfo>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate predicate = criteriaBuilder.conjunction();
                List<Expression<Boolean>> expressions = predicate.getExpressions();
                expressions.add(criteriaBuilder.equal(root.<Long>get("uid"),uid));

                root.join(root.getModel().getList("roles",Role.class),JoinType.LEFT);

                criteriaQuery.distinct(true);
                return predicate;
            }
        };
        return userInfoRepository.findAll(specification);
    }

    @Override
    public List<Role> findAllRoles(UserInfo user) {
        return null;
    }
}
