package com.thread;

public class TestThreads extends Thread {
	public static void main(String[] args) {
		// 调用start方法，相当于开启了一个线程------直接调用run方法相当于主线程执行方法
		for (int j = 0; j < 100; j++) {
			System.out.println(Thread.currentThread().getName() + "   " + j);

		}
		TestThreads th = new TestThreads();
		TestThreads th1 = new TestThreads();
		// 守护线程 当主线程结束 子线程立即结束
		// th.setDaemon(true);
		// th1.setDaemon(true);

		th.start();
		th1.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "====" + i);
		}
	}
}
