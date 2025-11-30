package com.automicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试原子整数的类
 * 该类用于演示多线程环境下原子操作的使用
 */
public class TestAutomicInteger {
    /**
     * 程序入口方法
     * @param args 命令行参数
     * @throws InterruptedException 可能抛出的线程中断异常
     */
	public static void main(String[] args) throws InterruptedException {
        // 创建自定义线程对象
		MyThread m = new MyThread();
        // 创建第一个线程并关联自定义线程对象
		Thread t = new Thread(m);
        // 创建第二个线程并关联同一个自定义线程对象
		Thread t1 = new Thread(m);

        // 启动第一个线程
		t.start();
        // 启动第二个线程
		t1.start();
        // 主线程休眠500毫秒，等待其他线程执行完成
		Thread.sleep(500);
        // 打印原子整数的当前值
		System.out.println(MyThread.ai.get());
	}
}

class MyThread implements Runnable {

	static AtomicInteger ai = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			ai.getAndIncrement();
		}
	}
}