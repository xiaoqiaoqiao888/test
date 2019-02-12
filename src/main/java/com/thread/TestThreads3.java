package com.thread;

public class TestThreads3 extends Thread {

	private int j;

	public static void main(String[] args) {
		TestThreads3 th = new TestThreads3();
		TestThreads3 th1 = new TestThreads3();

		th.start();
		th1.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			j++;
		}
		System.out.println(j);
	}
}
