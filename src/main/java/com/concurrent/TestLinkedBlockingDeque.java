package com.concurrent;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试LinkedBlockingDeque线程池的示例类
 * 演示了线程池的核心线程数、最大线程数、队列任务数的变化情况
 */
public class TestLinkedBlockingDeque {
	public static void main(String[] args) {
        // 创建一个线程池，核心线程数为3，最大线程数为6，空闲线程存活时间为5秒
        // 使用LinkedBlockingDeque作为工作队列
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>());
        // 创建一个Runnable任务，执行时会休眠2秒并打印当前线程名称
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + " run");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

        // 执行前三个任务
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---先开三个---");
        // 打印线程池当前状态：核心线程数、线程池大小、队列任务数
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
        // 再执行三个任务
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---再开三个---");
        // 再次打印线程池当前状态
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		try {
            // 主线程休眠8秒，等待前面的任务执行完毕
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("----8秒之后----");
        // 打印8秒后线程池的状态
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
	}
}
