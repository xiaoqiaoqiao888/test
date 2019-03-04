package com.mianshi;

public class TestTryFinally {
	public static void main(String[] args) {

		String returnTry = returnTry();

		System.out.println(returnTry);
	}

	@SuppressWarnings("finally")
	public static String returnTry() {
		try {
			String str = "try";
			return str;
		} catch (Exception e) {
			String str = "catch";
			return str;
		} finally {
			String str = "finally";
			return str;
		}
	}
}
