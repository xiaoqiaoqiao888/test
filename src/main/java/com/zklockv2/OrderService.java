package com.zklockv2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import com.zk.Lock;

public class OrderService implements Runnable {

	CountDownLatch latch;
	/**
	 * 搞一个全局变量，以更好地演示效果
	 */
	private static int count = 0;

	Lock lock;

	public OrderService(CountDownLatch latch, Lock lock) {
		this.latch = latch;
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			lock.getLock();
			// 获得锁后的业务逻辑(通常是操作某个共享资源)
			String orderId = getOrderId();
			System.out.println("订单号：" + orderId);
			for (int i = 0; i < 99999999; i++) {
				// 模拟耗时的业务逻辑
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
			latch.countDown();
		}
	}

	public String getOrderId() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(new Date()) + "-" + (++count);
	}
}
