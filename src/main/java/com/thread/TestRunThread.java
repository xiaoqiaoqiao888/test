package com.thread;

public class TestRunThread extends Thread {
	private boolean isRunning = true;
	int m;

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	@Override
	public void run() {
		System.out.println("进入run了");
		while (isRunning == true) {
			int a = 2;
			int b = 3;
			int c = a + b;
			m = c;
			// System.out.println(m);
			// try {
			// Thread.sleep(1000);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			// JVM会尽力保证内存的可见性，即便这个变量没有加同步关键字
		}
		System.out.println(m + " run");
		System.out.println("run 线程被停止了！");
	}

	public static void main(String[] args) throws InterruptedException {
		TestRunThread thread = new TestRunThread();

		thread.start();
		Thread.sleep(1000);
		thread.setRunning(false);

		System.out.println("已经赋值为false");
	}
}
