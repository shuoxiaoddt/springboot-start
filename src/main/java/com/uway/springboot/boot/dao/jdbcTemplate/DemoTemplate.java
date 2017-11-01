package com.uway.springboot.boot.dao.jdbcTemplate;

import com.uway.springboot.boot.entity.BootTableDemo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by uwayxs on 2017/11/1.
 */
@Repository
public class DemoTemplate {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public BootTableDemo getById(long id){
        String sql = "select * from boot_table_demo where id = ?";
        RowMapper<BootTableDemo> rowMapper =
                new BeanPropertyRowMapper(BootTableDemo.class);
        return jdbcTemplate.queryForObject(sql,rowMapper,id);
    }
}
