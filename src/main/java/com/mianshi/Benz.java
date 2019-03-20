package com.mianshi;

class Car {
	public void run() {
		System.out.println("这是父类run()方法");
	}
}

public class Benz extends Car {
	public void run() {
		System.out.println("这是Benz的run()方法");

	}

	public void price() {
		System.out.println("Benz:800000$");
	}

	public static void main(String[] args) {
		Car car = new Benz();
		car.run();
		// car.price();程序报错
	}
}
