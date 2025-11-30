package com.aop;

import org.springframework.stereotype.Service;

/**
 * AopService类是一个服务层组件，使用@Service注解标记
 * 该类可能用于演示AOP(面向切面编程)的功能
 */
@Service
public class AopService {
    /**
     * test方法是一个简单的业务方法
     * 在控制台输出执行业务逻辑的信息
     */
	public void test() {
		System.out.println("执行业务逻辑。。。。");
	}
}
