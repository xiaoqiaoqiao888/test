package com.mianshi;

public class TestFatherChild {

	public TestFatherChild() {
		System.out.println("父类构造器");
	}

	static {
		System.out.println("父类静态代码块");
	}

	{
		System.out.println("父类普通代码块");
	}

	public void getFather() {

		System.out.println("父类普通方法");

	}

	public static void main(String[] args) {
		System.out.println("main");
		new Child();
		new Child();
	}
}

class Child extends TestFatherChild {
	

	static {
		System.out.println("子类静态代码块");
	}

	

	public void getChild() {

		System.out.println("子类普通方法");

	}
	public Child() {
		System.out.println("子类构造器");
	}
	
	{
		System.out.println("子类普通代码块");
	}
}