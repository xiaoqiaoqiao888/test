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

/**
 * Curator分布式锁测试类
 * 使用Curator框架实现分布式互斥锁，模拟多个线程获取订单号
 */
public class CuratorLockTest {

	public static void main(String[] args) {
        // 创建倒计时锁，用于控制所有线程同时开始执行
		final CountDownLatch latch = new CountDownLatch(1);
        // 创建线程池，用于管理多个线程
		ExecutorService service = Executors.newCachedThreadPool();

        // 创建Curator客户端，连接Zookeeper服务器
        // 使用指数退避重试策略，初始间隔1000ms，最多重试3次
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181",
				new ExponentialBackoffRetry(1000, 3));

        // 启动Zookeeper客户端
		client.start();
        // 创建分布式互斥锁，锁的路径为/testMutex
		final InterProcessMutex lock = new InterProcessMutex(client, "/testMutex");
        // 创建10个线程，模拟多个客户端同时获取订单号
		for (int i = 0; i < 10; i++) {
			service.submit(new Runnable() {
				public void run() {
					try {
                        // 等待倒计时锁归零，确保所有线程同时开始竞争锁
						latch.await();
                        // 获取分布式锁
						lock.acquire();
                        // 获取订单号并打印
						System.out.println(Thread.currentThread().getName() + ":获得的订单号为：" + getDateStr());
                        // 释放锁
						lock.release();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
        // 倒计时锁减1，所有线程开始执行
		latch.countDown();
        // 关闭线程池
		service.shutdown();
	}

    // 订单号计数器
	static int num = 0;

    /**
     * 生成订单号
     * @return 格式化的订单号，包含时间戳和递增数字
     */
	public static String getDateStr() {
        // 创建日期格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        // 生成订单号：当前时间+递增数字
		String format = sdf.format(new Date()) + num++;
		return format;
	}
}
