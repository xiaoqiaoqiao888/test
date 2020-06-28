package com.file;

class A {
	private static int numA;
	private int numA2;

	static {
		System.out.println("A的静态字段 : " + numA);
		System.out.println("A的静态代码块");
	}

	{
		System.out.println("A的成员变量  : " + numA2);
		System.out.println("A的非静态代码块");
	}

	public A() {
		System.out.println("A的构造器");
	}

	public A(int n) {
		System.out.println("A的有参构造");
		this.numA2 = n;
	}
}

class B extends A {
	private static int numB;
	private int numB2;

	static {
		System.out.println("B的静态字段 : " + numB);
		System.out.println("B的静态代码块");
	}

	{
		System.out.println("B的成员变量 : " + numB2);
		System.out.println("B的非静态代码块");
	}

	public B() {
		System.out.println("B的构造器");
	}

	public B(int n) {
		super(n);
		System.out.println("B的有参构造");
		this.numB2 = n;
	}
}

public class ClassLoad {
	public static void main(String[] args) {
		A anotherB = new B(0);// 思考有参构造的输出结果
		System.out.println(anotherB);
	}
}