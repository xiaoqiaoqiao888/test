package com.concurrent;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试同步队列(SynchronousQueue)的线程池示例类
 * 演示了使用SynchronousQueue作为工作队列时线程池的行为特点
 */
public class TestSynchronousQueue {
    /**
     * 程序主入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 创建一个线程池，核心线程数为3，最大线程数为6，空闲线程存活时间为5秒，使用SynchronousQueue作为工作队列
		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>());

        // 创建一个可运行的任务，任务内容是睡眠2秒后打印当前线程名称
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);  // 休眠2秒
					System.out.println(Thread.currentThread().getName() + " run");  // 打印当前线程名称
				} catch (InterruptedException e) {
					e.printStackTrace();  // 打印中断异常信息
				}
			}
		};

        // 执行三次任务
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---先开三个---");  // 标记：已提交三个任务
        // 打印线程池当前状态：核心线程数、线程池大小、队列任务数
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
        // 再次执行三次任务
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---再开三个---");  // 标记：已提交六个任务
        // 再次打印线程池当前状态
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		try {
			Thread.sleep(8000);  // 主线程休眠8秒
		} catch (InterruptedException e) {
			e.printStackTrace();  // 打印中断异常信息
		}
		System.out.println("----8秒之后----");  // 标记：8秒后
        // 打印8秒后线程池的状态
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
	}

}
