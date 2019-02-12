package com.curator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Recipes_Lock {
	static String lock_path = "/curator_recipes_lock_path";

	// static CuratorFramework client =
	// CuratorFrameworkFactory.builder().connectString("localhost:2181")
	// .retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
	public static void main(String[] args) throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181",
				new ExponentialBackoffRetry(1000, 3));
		client.start();
		final InterProcessMutex lock = new InterProcessMutex(client, lock_path);
		final CountDownLatch down = new CountDownLatch(1);
		for (int i = 0; i < 30; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						down.countDown();
						System.out.println("调用countDown方法！！！");
						// down.await();
						// System.out.println("调用await方法！！！");
						lock.acquire();
						System.out.println("调用acquire方法！！！");
					} catch (Exception e) {
						e.printStackTrace();
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss|SSS");
					String orderNo = sdf.format(new Date());
					System.out.println("生成的订单号是：" + orderNo);
					try {
						lock.release();
						System.out.println("调用release方法！！！");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		down.await();
		System.out.println("调用await方法！！！");
		// down.countDown();
		// System.out.println("调用countDown方法！！！");
	}
}
