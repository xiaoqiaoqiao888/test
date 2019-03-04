package com.mianshi;

public class TestYunSuanFu {
	public static void main(String[] args) {
		int i = 12;
		System.out.println(i += i -= i *= i);

		// 144
		i = i - i;// -132
		i += i;// -120
	}
}
