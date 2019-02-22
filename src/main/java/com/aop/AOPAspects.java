package com.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类
 * 
 * @author qiaodongjie
 * @date 2019年2月22日 上午10:09:30
 *
 */
@Component
@Aspect
public class AOPAspects {

	@Pointcut("within(AopService)")
	public void pointcut() {
		System.out.println("I am pointcut...........");
	}

	@Around("pointcut()")
	public Object invokeMethod(ProceedingJoinPoint point) throws Throwable {

		// 开始
		Long begin = new Date().getTime();
		System.out.println("开始执行。。。。。");
		// 执行业务逻辑
		Object proceed = point.proceed();
		// 结束
		Long end = new Date().getTime();
		System.out.println("结束执行。。。。。");
		System.out.println("方法" + point.getSignature().toShortString() + "耗时：" + (end - begin));

		return proceed;

	}
}
