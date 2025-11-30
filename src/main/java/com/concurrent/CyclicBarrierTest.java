package com.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest类
 * 该类演示了CyclicBarrier（循环屏障）的使用，它是一个同步工具，
 * 允许一组线程互相等待，直到所有线程都到达某个公共屏障点。
 */
public class CyclicBarrierTest {
    /**
     * 程序的入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 创建一个CyclicBarrier实例，参数3表示需要等待3个线程到达屏障点
		CyclicBarrier barrier = new CyclicBarrier(3);
        // 循环创建并启动3个线程，线程数量与屏障等待的线程数相同
		for (int i = 0; i < barrier.getParties(); i++) {
            // 创建新线程并启动，线程名为"队友"+i
			new Thread(new MyRunnable(barrier), "队友" + i).start();
		}
        // 主线程执行完毕，打印输出
		System.out.println("main function is finished.");
	}

    /**
     * MyRunnable类
     * 实现Runnable接口，作为线程执行的任务类
     */
	private static class MyRunnable implements Runnable {
        // 声明CyclicBarrier类型的成员变量
		private CyclicBarrier barrier;

        /**
         * 构造方法
         * @param barrier 传入的CyclicBarrier实例
         */
		public MyRunnable(CyclicBarrier barrier) {
			this.barrier = barrier;
		}

        /**
         * 线程执行的方法
         * 每个线程执行3次循环，每次循环模拟通过障碍物
         */
		public void run() {
            // 循环3次，表示通过3个障碍物
			for (int i = 0; i < 3; i++) {
				try {
                    // 创建随机数生成器
					Random rand = new Random();
					int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;// 产生1000到3000之间的随机整数
					Thread.sleep(randomNum);
					System.out.println(Thread.currentThread().getName() + ", 通过了第" + i + "个障碍物, 使用了 "
							+ ((double) randomNum / 1000) + "s");
					this.barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
