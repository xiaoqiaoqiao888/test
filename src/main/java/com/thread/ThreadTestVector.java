package com.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class ThreadTestVector {
	/**
	 * 这里要比较的是arraylist 和Vector来测试 arraylist 是线程不安全的 Vector 线程安全的
	 *
	 */
	public static void test() {
		// 用来测试的list集合
		List<Object> list1 = new ArrayList<Object>();
		List<Object> list = Collections.synchronizedList(list1);
		// List<Object> list = new Vector<Object>();
		// 线程数
		int threadCount = 10000;
		// 用来让主线等待thread 个执行完毕
		CountDownLatch count = new CountDownLatch(threadCount);
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new MyThread(list, count));
			thread.start();
		}
		try {
			// 主线程所有都执行完成后，再向下执行
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			test();
		}
	}
}