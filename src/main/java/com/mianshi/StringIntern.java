package com.mianshi;

/**
 * StringIntern类用于演示Java中字符串常量池(intern)的使用
 * 该类通过比较不同方式创建的字符串对象，展示字符串常量池的特性
 */
public class StringIntern {
    /**
     * 程序的入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
		// 使用new关键字创建一个新的String对象，存放在堆内存中
		String b = new String("java");
		// 直接使用字面量创建String对象，JVM会将其放入字符串常量池
		String a = "java";
		// 调用intern()方法，返回字符串在常量池中的引用
		// 然后与a比较，判断它们是否指向同一个对象
		System.out.println(b.intern() == a);
	}
}
