package com.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 测试CountDownLatch类的使用示例
 * 该类演示了如何使用CountDownLatch实现线程同步
 */
public class TestCountDownLatch {

	public static void main(String[] args) {
        // 创建一个CountDownLatch实例，计数器值为5
		final CountDownLatch countDownLatch = new CountDownLatch(5);

        // 创建CountDownDemo实例，传入CountDownLatch对象
		CountDownDemo demo = new CountDownDemo(countDownLatch);

        // 记录开始时间
		long start = System.currentTimeMillis();
        // 创建并启动5个线程
		for (int i = 0; i < 5; i++) {
			new Thread(demo).start();
		}
		try {
            // 主线程等待，直到计数器减到0
			countDownLatch.await();
		} catch (InterruptedException e) {
            // 打印中断异常信息
			e.printStackTrace();
		}
        // 记录结束时间
		long end = System.currentTimeMillis();

        // 输出总耗时
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