package com.uway.springboot.boot;

import com.uway.springboot.boot.banner.UBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *  @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 */
@SpringBootApplication
@ServletComponentScan//加次配置可以扫描到自己书写的servlet和filter
public class BootStrapApplication {

	public static void main(String[] args) {

		SpringApplication.run(BootStrapApplication.class, args);
	}
}
