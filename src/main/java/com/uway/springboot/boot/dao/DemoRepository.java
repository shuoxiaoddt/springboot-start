package com.uway.springboot.boot.dao;

import com.uway.springboot.boot.entity.BootTableDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by uwayxs on 2017/11/1.
 */
@Repository
public interface DemoRepository extends CrudRepository<BootTableDemo,Long> {
}
