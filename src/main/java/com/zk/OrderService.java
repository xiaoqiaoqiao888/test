package com.zk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 业务逻辑
 * 
 * @author qiaodongjie
 * @date 2018年12月28日 上午11:05:55
 *
 */
public class OrderService implements Runnable {
	CountDownLatch latch;
	/**
	 * 搞一个全局变量，以更好地演示效果
	 */
	private static int count = 0;

	Lock lock = new ZkDistributeLock();

	public OrderService(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			lock.getLock();
			String orderId = getOrderId();
			System.out.println("订单号：" + orderId);
			for (int i = 0; i < 999999; i++) {
				// 模拟耗时长的业务逻辑
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unLock();
			latch.countDown();
		}
	}

	private String getOrderId() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return simpleDateFormat.format(new Date()) + "-" + (++count);
	}

}
