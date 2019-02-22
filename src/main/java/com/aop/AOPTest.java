package com.aop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AOPTest {
	@Autowired
	AopService aopService;

	public static void main(String[] args) {
		SpringApplication.run(AOPTest.class, args);
	}

	@PostConstruct
	public void test() {
		aopService.test();
	}

	@PostConstruct
	public void test1() {
		aopService.test();
	}
}
