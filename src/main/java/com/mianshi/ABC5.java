package com.mianshi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC5 {

	private int cond = 1;// 通过cond来确定A B C的输出
	private Lock lock = new ReentrantLock();// 通过JDK5中的锁来保证线程的访问的互斥
	private Condition condition = lock.newCondition();// 线程协作

	public static void main(String[] args) {
		ABC5 abc = new ABC5();// 内部类线程执行方式jdk1.5
		ThreadA ta = abc.new ThreadA();// 声明3个runnable类
		ThreadB tb = abc.new ThreadB();
		ThreadC tc = abc.new ThreadC();
		ExecutorService executor = Executors.newFixedThreadPool(3);// 通过线程池执行
		for (int i = 0; i < 10; i++) {
			executor.execute(ta);
			executor.execute(tb);
			executor.execute(tc);
		}
		executor.shutdown();// 关闭线程池

	}

	class ThreadA implements Runnable {

		public void run() {
			lock.lock();
			try {
				while (true) {
					if (cond % 3 == 1) {
						System.out.print(cond + ":A");
						cond++;
						condition.signalAll();
						break;
					} else {
						try {
							condition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} finally {
				lock.unlock();
			}
		}

	}

	class ThreadB implements Runnable {
		public void run() {
			lock.lock();
			try {
				while (true) {
					if (cond % 3 == 2) {
						System.out.print(cond + ":B");
						cond++;
						condition.signalAll();
						break;
					} else {
						try {
							condition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} finally {
				lock.unlock();
			}
		}

	}

	class ThreadC implements Runnable {
		public void run() {
			lock.lock();
			try {
				while (true) {
					if (cond % 3 == 0) {
						System.out.println(cond + ":C");
						cond++;
						condition.signalAll();
						break;
					} else {
						try {
							condition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} finally {
				lock.unlock();
			}
		}

	}

}
