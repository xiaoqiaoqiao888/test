package com.mianshi;

public class TestDiGui {
	public static void main(String[] args) {
		int mul = getMul(1);

		System.out.println(mul);
	}

	public static int getMul(int i) {
		if (i == 1) {
			return 1;
		}
		return i * getMul(i - 1);
	}

}
