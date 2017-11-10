package com.uway.springboot.boot;

import com.uway.springboot.boot.async.AsyncMothod;
import com.uway.springboot.boot.dao.UserInfoRepository;
import com.uway.springboot.boot.dao.jdbcTemplate.DemoTemplate;
import com.uway.springboot.boot.entity.BootTableDemo;
import com.uway.springboot.boot.entity.PropEntity;
import com.uway.springboot.boot.entity.RedisInfo;
import com.uway.springboot.boot.entity.UserInfo;
import com.uway.springboot.boot.mail.CustomerMailSender;
import com.uway.springboot.boot.service.DemoService;
import com.uway.springboot.boot.service.RedisInfoService;
import com.uway.springboot.boot.service.UserInfoService;
import com.uway.springboot.boot.util.BeanUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.uway.springboot.boot.mapper")
@EnableAsync
@EnableConfigurationProperties(PropEntity.class)
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
	@Autowired
	private CustomerMailSender customerMailSender;
	@Autowired
	private AsyncMothod asyncMothod;
	@Autowired
	private PropEntity propEntity;
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
	@Test
	public void sendMail(){
		customerMailSender.sendSimpleMail();
	}
	@Test
	public void async(){
		asyncMothod.task1();
		asyncMothod.task2();
		asyncMothod.task3();
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	@Test
	public void properties(){
		System.out.println(propEntity);
	}
}
