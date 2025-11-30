package com.aop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Spring Boot AOP测试类
 * 使用@SpringBootApplication注解标记这是一个Spring Boot应用程序
 * 使用@EnableAspectJAutoProxy注解启用AspectJ自动代理功能，支持AOP（面向切面编程）
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class AOPTest {
    // 使用@Autowired注解自动注入AopService实例，实现依赖注入
	@Autowired
	AopService aopService;

	/**
	 * 程序入口方法
	 * @param args 命令行参数，用于接收程序启动时传入的参数
	 */
	public static void main(String[] args) { // main方法，Java程序的入口点，程序执行的起点
		SpringApplication.run(AOPTest.class, args); // 调用SpringApplication的run方法启动Spring应用程序，传入主类和命令行参数
	}

	/**
	 * 使用@PostConstruct注解标记的方法会在依赖注入完成后自动执行
	 * 用于测试AOP功能，验证切面是否能够正确拦截方法调用
	 */
	@PostConstruct
	public void test() {
		// 调用aopService的test方法，此方法可能会被AOP切面拦截
		aopService.test();
	}

	/**
	 * 另一个使用@PostConstruct注解标记的方法
	 * 同样用于测试AOP功能，验证切面是否能够正确拦截多个方法调用
	 */
	@PostConstruct
	public void test1() {
		// 再次调用aopService的test方法，用于测试AOP切面对多次调用的处理
		aopService.test();
	}
}
