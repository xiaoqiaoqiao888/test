package com.automicInteger;

public class TestSync implements Runnable {

	public static void main(String[] args) throws InterruptedException {
		TestSync sync = new TestSync();
		new Thread(sync, "A").start();
		new Thread(sync, "B").start();
		Thread.sleep(100);
	}

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 5; i++) {

				System.out.println(Thread.currentThread().getName() + "----------------------" + i);
			}
		}

	}
}
