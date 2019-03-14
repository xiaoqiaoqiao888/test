package com.mianshi.reflect;

/**
 * final 修饰的变量 没有初始值 可以被修改
 * 
 * @author qiaodongjie
 * @date 2019年3月13日 下午2:45:40
 *
 */
public class Test2 {
	private final String NAME;

	public Test2() {

		this.NAME = "哈哈哈";
	}

	public String getName() {
		return NAME;
	}
}
