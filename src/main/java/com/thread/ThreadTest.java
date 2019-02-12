package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(1);
		ExecutorService service = Executors.newCachedThreadPool();
		final Lock lock = new ReentrantLock();
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {
				public void run() {
					try {
						latch.await();
						lock.lock();
						System.out.println(Thread.currentThread().getName() + ":获得的订单号为：" + getDateStr());
						lock.unlock();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		latch.countDown();
		service.shutdown();
	}
static int num=0;
	public static String getDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = sdf.format(new Date()) + num++;
		return format;
	}
}
