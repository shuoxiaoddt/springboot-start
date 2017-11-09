package com.uway.springboot.boot.dao;

import com.uway.springboot.boot.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by uwayxs on 2017/11/7.
 */
public interface PermissionRepository extends JpaRepository<Permission,Long> {

}
