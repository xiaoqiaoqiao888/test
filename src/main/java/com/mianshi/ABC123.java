package com.mianshi;

public class ABC123 {
	// 打印数字的线程
	Thread th1 = new Thread(() -> {
		synchronized (this) {
			for (int i = 1; i < 53; i++) {
				System.out.print(i);
				if (i % 2 == 0) { // 判读i是否等于0，
					try {
						this.notify();// 唤起下个线程
						this.wait();// 等于0让该线程停止
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	});
	// 打印字母的线程
	Thread th2 = new Thread(() -> {
		synchronized (this) {
			for (int i = 0; i < 26; i++) {
				System.out.print((char) +(65 + i));
				this.notify();// 唤起其他线程
				try {
					Thread.sleep(1000);
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	});

	public static void main(String[] args) {
		ABC123 w2 = new ABC123();
		w2.th2.start();
		w2.th1.start();
	}
}
