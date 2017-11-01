package com.uway.springboot.boot;

import com.uway.springboot.boot.dao.jdbcTemplate.DemoTemplate;
import com.uway.springboot.boot.entity.BootTableDemo;
import com.uway.springboot.boot.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoTemplate demoTemplate;
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

}
