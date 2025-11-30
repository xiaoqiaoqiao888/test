package com.automicInteger;

/**
 * 测试同步的类，实现了Runnable接口
 */
public class TestSync implements Runnable {

    /**
     * 程序的主入口方法
     * @param args 命令行参数
     * @throws InterruptedException 可能抛出的线程中断异常
     */
	public static void main(String[] args) throws InterruptedException {
        // 创建TestSync实例
		TestSync sync = new TestSync();
        // 启动线程A，执行同一个TestSync实例的run方法
		new Thread(sync, "A").start();
        // 启动线程B，执行同一个TestSync实例的run方法
		new Thread(sync, "B").start();
        // 主线程休眠100毫秒
		Thread.sleep(100);
	}

    /**
     * 实现Runnable接口的run方法，用于线程执行
     * 使用synchronized关键字实现同步代码块，确保同一时间只有一个线程能执行
     */
	@Override
	public void run() {

        // 使用this作为同步锁，确保多个线程同步执行
		synchronized (this) {
            // 循环打印5次，每次打印当前线程名称和循环变量i
			for (int i = 0; i < 5; i++) {

                // 打印当前线程名称和循环变量i
				System.out.println(Thread.currentThread().getName() + "----------------------" + i);
			}
		}

	}
}
