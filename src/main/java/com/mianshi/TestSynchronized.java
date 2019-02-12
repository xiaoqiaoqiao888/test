package com.mianshi;

public class TestSynchronized {
	public static void main(String[] args) {
		getStr("123");
		System.out.println("---------------------main--------------------");
	}

	public synchronized static void getStr(String str) {
		getStrs(str);
		System.out.println("---------------------getStr--------------------");
	}

	public synchronized static void getStrs(String str) {
		System.out.println("---------------------getStrs--------------------");
	}
}
