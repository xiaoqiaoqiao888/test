package com.JDKProxy;

/**
 * 测试代理类的示例程序
 * 该类用于演示JDK动态代理的使用方法
 */
public class TestProxy {
	/**
	 * 程序入口方法
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		// 设置系统属性，保存生成的代理类文件到本地，便于调试
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

		// jdk动态代理测试
		// 创建UserProxy实例，并传入目标对象UserDaoImpl
		// 通过getProxy方法获取代理对象
		UserDao userDao = new UserProxy(new UserDaoImpl()).getProxy();
		// 通过代理对象调用方法，实际上会调用UserProxy中的invoke方法
		userDao.doSomething();
	}
}
