package com.thread;

public class TestThreads2 extends Thread {

	private int i;

	public static void main(String[] args) {
		TestThreads2 th = new TestThreads2();
		new Thread(th, "线程1").start();
	}

	@Override
	public void run() {
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "====" + i);
		}
	}
}
