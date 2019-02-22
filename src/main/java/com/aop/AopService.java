package com.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {
	public void test() {
		System.out.println("执行业务逻辑。。。。");
	}
}
