package com.uway.springboot.boot.service;

import com.uway.springboot.boot.entity.Role;
import java.util.List;
import com.uway.springboot.boot.entity.Permission;
import com.uway.springboot.boot.entity.UserInfo;

/**
 * Created by uwayxs on 2017/11/7.
 */

public interface UserInfoService {
    UserInfo findByUsername(String username);

    List<UserInfo> findRoleInfo(Long uid);

    List<Role> findAllRoles(UserInfo user);

}
