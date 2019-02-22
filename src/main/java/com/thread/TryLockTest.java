package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {

	private Lock lock = new ReentrantLock();

	public void method(Thread thread) {

		if (lock.tryLock()) {
			try {
				System.out.println("当前线程" + thread.getName() + "获得了锁！");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("当前线程" + thread.getName() + "释放了锁!");
				lock.unlock();
			}
		} else {
			System.out.println("我是" + Thread.currentThread().getName() + "有人占着锁，我就不要啦");
		}
	}

	public static void main(String[] args) {
		TryLockTest lockTest = new TryLockTest();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				lockTest.method(Thread.currentThread());
			}
		}, "t1");
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				lockTest.method(Thread.currentThread());
			}
		}, "t2");

		t1.start();
		t2.start();
	}
}
