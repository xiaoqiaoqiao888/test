package com.other;

public class ThreadLocalTest {
/**
 * 主方法，程序的入口点
 * @param args 命令行参数数组
 */
	public static void main(String[] args) {
    // 创建一个ThreadLocal变量，用于存储线程局部变量
		ThreadLocal<String> tl = new ThreadLocal<>();
    // 向ThreadLocal中设置值"123"
		tl.set("123");
    // 获取JVM可用的处理器核心数
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		
    // 打印可用的处理器核心数到控制台
		System.out.println(availableProcessors);
	}
}
