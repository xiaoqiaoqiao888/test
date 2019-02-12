package com.mianshi;

public class TestReverse {

	public static void main(String[] args) {
		String reverseString = reverseString("123456");

		System.out.println(reverseString);
	}

	// 反转字符串
	public static String reverseString(String s) {
		if (s.isEmpty())
			return s;
		return reverseString(s.substring(1)) + s.charAt(0);
	}
}
