package com.mianshi.reflect;

import java.lang.reflect.Field;

public class TestReflect2 {
	public static void main(String[] args) throws Exception {
		Test2 test = new Test2();
		Class<? extends Test2> mClass = test.getClass();
		// 获取NAME变量进行修改
		Field field = mClass.getDeclaredField("NAME");
		if (field != null) {
			field.setAccessible(true);
			System.out.println("modify before " + field.get(test));
			// 进行修改
			field.set(test, "钢丝");
			System.out.println("modify after " + field.get(test));
			System.out.println("getName = " + test.getName());
		}
	}
}
