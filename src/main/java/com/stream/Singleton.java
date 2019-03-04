package com.stream;

import java.io.Serializable;

/**
 * 双重验证锁 单例 序列化会导致单例破坏 readResolve可以解决
 * 
 * @author qiaodongjie
 * @date 2019年2月28日 下午5:11:52
 *
 */
public class Singleton implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8402285317647309152L;
	private volatile static Singleton singleton;

	private Singleton() {
	}

	public static Singleton getSingleton() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	private Object readResolve() {
		return singleton;
	}
}
