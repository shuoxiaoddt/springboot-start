package com.uway.springboot.boot;

import com.uway.springboot.boot.dao.UserInfoRepository;
import com.uway.springboot.boot.dao.jdbcTemplate.DemoTemplate;
import com.uway.springboot.boot.entity.BootTableDemo;
import com.uway.springboot.boot.entity.RedisInfo;
import com.uway.springboot.boot.entity.Role;
import com.uway.springboot.boot.entity.UserInfo;
import com.uway.springboot.boot.service.DemoService;
import com.uway.springboot.boot.service.RedisInfoService;
import com.uway.springboot.boot.service.UserInfoService;
import com.uway.springboot.boot.util.BeanUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.uway.springboot.boot.mapper")
public class BootApplicationTests {
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoTemplate demoTemplate;
	@Autowired
	private RedisInfoService redisInfoService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private UserInfoRepository userInfoRepository;
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
		redisInfoService.deleteFromCache(2L);
	}

	@Test
	public void getUserInfo(){
		UserInfo userInfo = userInfoService.findByUsername("admin");
		System.out.println(userInfo);

	}

}
