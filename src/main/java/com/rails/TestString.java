package com.rails;

public class TestString {
	public static void main(String[] args) {
		String str = "";
		if ("a".equals(str)) {
			System.out.println("相等为：" + "a".equals(str));
		}
		System.out.println("不相等为：" + !"a".equals(str));
	}
}
