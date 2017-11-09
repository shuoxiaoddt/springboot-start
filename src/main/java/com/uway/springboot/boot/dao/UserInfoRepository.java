package com.uway.springboot.boot.dao;

import com.uway.springboot.boot.entity.Role;
import java.util.List;
import com.uway.springboot.boot.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by uwayxs on 2017/11/7.
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>,JpaSpecificationExecutor{
    UserInfo findByUsername(String username);
}
