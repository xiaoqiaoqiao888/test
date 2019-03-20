package com.mianshi;

public class TestWEIYI {
	public static void main(String[] args) {
		byte a = 1;
		a = (byte) (a << 1);
		System.out.println(a);
		a = (byte) (a << 6);// 超出byte范围 最高位为1 为负数
		System.out.println(a);
	}
}
