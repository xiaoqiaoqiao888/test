package com.other;

public class ThreadLocalTest {
	public static void main(String[] args) {
		ThreadLocal<String> tl = new ThreadLocal<>();
		tl.set("123");
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		
		System.out.println(availableProcessors);
	}
}
