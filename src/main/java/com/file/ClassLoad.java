package com.file;

/**
 * 类A的示例，包含静态字段、成员变量、静态代码块、非静态代码块和构造器
 */
class A {
    // 静态私有变量numA，属于类级别
	private static int numA;
    // 实例私有变量numA2，属于对象级别
	private int numA2;

    // 静态代码块，在类加载时执行
	static {
		System.out.println("A的静态字段 : " + numA);  // 输出静态字段的初始值
		System.out.println("A的静态代码块");       // 静态代码块执行标记
	}

    // 非静态代码块，在创建对象时执行，在构造器之前
	{
		System.out.println("A的成员变量  : " + numA2);  // 输出成员变量的初始值
		System.out.println("A的非静态代码块");      // 非静态代码块执行标记
	}

    // 无参构造器
	public A() {
		System.out.println("A的构造器");    // 构造器执行标记
	}

    // 有参构造器，接受一个整数参数n
	public A(int n) {
		System.out.println("A的有参构造");   // 有参构造器执行标记
		this.numA2 = n;  // 将传入的参数值赋给成员变量numA2
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