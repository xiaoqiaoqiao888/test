package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	private Lock lock = new ReentrantLock();

	public void method(Thread thread) {
		try {
			lock.lock();
			System.out.println("当前线程" + thread.getName() + "获得了锁！");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("当前线程" + thread.getName() + "释放了锁！");
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		LockTest lockTest = new LockTest();

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
