package com.mianshi;

//Java中的静态方法只能继承，不能重写！！子类定义与父类同名的成员变量，并没有覆盖父类的成员变量，而是两个成员变量共存
public class TestAB {
	public static void main(String[] args) {
		A clazz = new B();
		System.out.println(clazz.a);
		clazz.f1();
		clazz.f2();
		clazz.f3();
	}
}

class A {
	public int a = 0;
	private String name = "name";

	public void f1() {
		System.out.println("A1");
	}

	public static void f2() {
		System.out.println("A2");
	}

	public void f3() {
		System.out.println(a);
	}
}

class B extends A {
	public int a = 1;

	public void f1() {
		System.out.println("B1");
	}

	public static void f2() {
		System.out.println("B2");
	}

	public void f3() {
		System.out.println(a);
	}

	public void f4() {
		System.out.println(a);
	}
}