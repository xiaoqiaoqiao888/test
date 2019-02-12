package com.zklockv2;

import java.util.concurrent.CountDownLatch;

public class Client2 {
	private static final String CONNECTION_STRING = "127.0.0.1:2181";
	private static final int THREADNUM = 10;

	public static void main(String[] args) throws Exception {
		// 计数器,用来控制主线程挂起，所有线程执行完成后再执行主线程
		CountDownLatch mylatch = new CountDownLatch(THREADNUM);
		long start = System.currentTimeMillis();
		// 开启多个线程模拟分布式环境下多个不同的客户端去获取订单号
		for (int i = 0; i < THREADNUM; i++) {
			new Thread(new OrderService(mylatch, new ZkDistributedLock(CONNECTION_STRING, "zpcand"))).start();
		}

		mylatch.await();
		System.out.println("cost:" + (System.currentTimeMillis() - start));
	}
}
