package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	public static void main(String[] args) {
		ExecutorService service = new ThreadPoolExecutor(4, 5, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>());
		for (int i = 0; i < 6; i++) {
			service.execute(() -> {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName());
			});
		}
		System.out.println(service);
		service.shutdown();
		System.out.println("----------------------------------------");
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);
		System.out.println("========================");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(service.isTerminated());
		System.out.println(service.isShutdown());
		System.out.println(service);

	}
}
