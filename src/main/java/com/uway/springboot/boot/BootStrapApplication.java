package com.uway.springboot.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class BootStrapApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootStrapApplication.class, args);
	}
}
