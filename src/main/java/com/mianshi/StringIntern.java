package com.mianshi;

public class StringIntern {
	public static void main(String[] args) {
		String b = new String("java");
		String a = "java";
		System.out.println(b.intern() == a);
	}
}
