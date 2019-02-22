package com.mianshi;

public class ChangeNoThirdNum {
	public static void main(String[] args) {
		int a = 1, b = 2;
		// 交换a、b的值
		// a = a + b;// a = 3, b = 2
		// b = a - b;// a = 3, b = 1
		// a = a - b;// a = 2, b = 1

		// 相同即为0，不同则为1（异或）
		a = a ^ b;// 0001 0010 -->0011
		b = a ^ b;// 0011 0010--->0001
		a = a ^ b;// 0011 0001--->0010
		System.out.println("a的值为：" + a);
		System.out.println("b的值为：" + b);
	}
}
