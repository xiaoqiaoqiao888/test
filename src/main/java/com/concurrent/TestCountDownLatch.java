package com.concurrent;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(5);

		CountDownDemo demo = new CountDownDemo(countDownLatch);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			new Thread(demo).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();

		System.out.println("耗费时间为：" + (end - start));
	}

}

class CountDownDemo implements Runnable {
	private CountDownLatch countDownLatch;

	public CountDownDemo(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		synchronized (this) {
			try {
				for (int i = 0; i < 5; i++) {
					if (i % 2 == 0) {
						System.out.println(i);
					}
				}
			} finally {
				System.out.println(countDownLatch.getCount());
				countDownLatch.countDown();
			}
		}
	}
}