package com.JDKProxy;

public class TestProxy {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		// jdk动态代理测试
		UserDao userDao = new UserProxy(new UserDaoImpl()).getProxy();
		userDao.doSomething();
	}
}
