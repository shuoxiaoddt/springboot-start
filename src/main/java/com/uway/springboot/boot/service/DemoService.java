package com.uway.springboot.boot.service;

import com.uway.springboot.boot.dao.DemoRepository;
import com.uway.springboot.boot.entity.BootTableDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by uwayxs on 2017/11/1.
 */
@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Transactional
    public void saveDemo(BootTableDemo bootTableDemo){
        demoRepository.save(bootTableDemo);
    }
}
