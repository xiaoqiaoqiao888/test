package com.jvm;

public class TestGCDetails {
	public static void main(String[] args) {
		for (int i = 0; i < 1000000000; i++) {
			Object obj = new Object();
			System.out.println(obj);
		}
	}
}
