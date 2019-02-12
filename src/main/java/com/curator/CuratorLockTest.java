package com.curator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CuratorLockTest {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(1);
		ExecutorService service = Executors.newCachedThreadPool();

		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",
				new ExponentialBackoffRetry(1000, 3));

		client.start();
		final InterProcessMutex lock = new InterProcessMutex(client, "/testMutex");
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {
				public void run() {
					try {
						latch.await();
						lock.acquire();
						System.out.println(Thread.currentThread().getName() + ":获得的订单号为：" + getDateStr());
						lock.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		latch.countDown();
		service.shutdown();
	}

	static int num = 0;

	public static String getDateStr() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = sdf.format(new Date()) + num++;
		return format;
	}
}
