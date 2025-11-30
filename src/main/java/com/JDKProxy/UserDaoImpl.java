package com.JDKProxy;

/**
 * UserDaoImpl类实现了UserDao接口
 * 该类提供了UserDao接口中定义的方法的具体实现
 */
public class UserDaoImpl implements UserDao {

    /**
     * 实现UserDao接口中的doSomething方法
     * 该方法在控制台输出一条信息
     */
	@Override
	public void doSomething() {
		System.out.println("UserDaoImpl do something");
	}
}
