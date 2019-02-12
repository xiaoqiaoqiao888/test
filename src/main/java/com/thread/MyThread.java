package com.thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {
	private List<Object> list;
	private CountDownLatch countDownLatch;

	public MyThread() {
	}

	public MyThread(List<Object> list, CountDownLatch countDownLatch) {
		this.list = list;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		// 给每个线程添加10个元素
		for (int i = 0; i < 10; i++) {
			list.add(new Object());
		}
		// 完成一个子线程
		countDownLatch.countDown();
	}
}
