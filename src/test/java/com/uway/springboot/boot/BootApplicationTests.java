package com.uway.springboot.boot;

import com.uway.springboot.boot.dao.jdbcTemplate.DemoTemplate;
import com.uway.springboot.boot.entity.BootTableDemo;
import com.uway.springboot.boot.entity.RedisInfo;
import com.uway.springboot.boot.service.DemoService;
import com.uway.springboot.boot.service.RedisInfoService;
import com.uway.springboot.boot.util.BeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoTemplate demoTemplate;
	@Autowired
	private RedisInfoService redisInfoService;

	@Test
	public void save() {
		BootTableDemo bootTableDemo = new BootTableDemo();
		bootTableDemo.setName("daisishab");
		demoService.saveDemo(bootTableDemo);
	}
	@Test
	public void getById(){
		long id = 1;
		BootTableDemo bootTableDemo = demoTemplate.getById(id);
		System.out.println(bootTableDemo);
	}
	@Test
	public void beanUtil(){
		System.out.println(BeanUtil.getBean("demoService"));
	}

	@Test
	public void saveRedisInfo(){
		RedisInfo redisInfo = new RedisInfo();
		redisInfo.setName("zhuzaishab");
		redisInfo.setPwd("123456!");
		redisInfoService.save(redisInfo);
	}
	@Test
	public void findById(){
		RedisInfo redisInfo = redisInfoService.findById(2L);
		System.out.println(redisInfo);
	}
	@Test
	public void deleteFromCache(){

	}


}
