package com.uway.springboot.boot.dao;

import com.uway.springboot.boot.entity.BootTableDemo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by uwayxs on 2017/11/1.
 */
public interface DemoRepository extends CrudRepository<BootTableDemo,Long> {
}
