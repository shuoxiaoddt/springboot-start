package com.uway.springboot.boot.dao;

import com.uway.springboot.boot.entity.RedisInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by uwayxs on 2017/11/6.
 */
@Repository
public interface RedisInfoRepository extends JpaRepository<RedisInfo,Long> {
}
