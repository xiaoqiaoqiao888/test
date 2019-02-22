package com.automicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAutomicInteger {
	public static void main(String[] args) throws InterruptedException {
		MyThread m = new MyThread();
		Thread t = new Thread(m);
		Thread t1 = new Thread(m);

		t.start();
		t1.start();
		Thread.sleep(500);
		System.out.println(MyThread.ai.get());
	}
}

class MyThread implements Runnable {

	static AtomicInteger ai = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			ai.getAndIncrement();
		}
	}
}