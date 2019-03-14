package com.mianshi.reflect;

/**
 * final 修饰的变量 有初始值 不能被修改
 * 
 * @author qiaodongjie
 * @date 2019年3月13日 下午2:45:03
 *
 */
public class Test {
	private final String NAME = "亦袁非猿";

	public String getName() {
		return NAME;
	}
}
