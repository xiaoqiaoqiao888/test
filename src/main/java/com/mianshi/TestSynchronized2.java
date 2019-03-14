package com.mianshi;

public class TestSynchronized2 {
	public static void main(String[] args) {

		synchronized (args) {
			int i = 0;
			i++;
		}
		System.out.println("---------------------main--------------------");
	}

}
