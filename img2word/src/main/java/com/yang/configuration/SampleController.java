package com.yang.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.ApplicationScope;

@MapperScan("com.yang.dao")
@SpringBootApplication
@ComponentScan(basePackages="com.yang")
public class SampleController {

	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}
}
