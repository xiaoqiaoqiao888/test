package com.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * UserProxy类是一个动态代理处理器，实现了InvocationHandler接口，
 * 用于在目标对象的方法调用前后添加额外的处理逻辑。
 */
public class UserProxy implements InvocationHandler {
    // 目标对象，即被代理的对象
	private Object target;

    /**
     * 构造函数，初始化目标对象
     * @param target 被代理的目标对象
     */
	public UserProxy(Object target) {

        // 将传入的目标对象赋值给类的成员变量
		this.target = target;
	}

    /**
     * 获取目标对象的代理对象
     * @param <T> 泛型类型，表示代理对象的类型
     * @return 返回目标对象的代理实例
     */
	@SuppressWarnings("unchecked")
	public <T> T getProxy() {
        // 使用Proxy类的newProxyInstance方法创建代理实例
        // 参数1：目标对象的类加载器
        // 参数2：目标对象实现的所有接口
        // 参数3：调用处理器，即当前UserProxy实例
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

	}

    /**
     * 方法调用处理器，在目标方法调用前后添加额外的处理逻辑
     * @param proxy 代理对象
     * @param method 被调用的方法
     * @param args 方法调用参数
     * @return 方法调用的返回值
     * @throws Throwable 方法调用可能抛出的异常
     */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 在方法调用前执行的操作
		System.out.println("Do something before");
        // 调用目标对象的方法并获取返回值
		Object result = method.invoke(target, args);
        // 在方法调用后执行的操作
		System.out.println("Do something after");
        // 返回方法调用的结果
		return result;
	}

}
