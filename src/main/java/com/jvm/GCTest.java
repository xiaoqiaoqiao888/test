package com.jvm;

/**
 * 这是一个用于测试Java垃圾回收机制的示例类
 * 通过分配不同大小的内存块，观察垃圾回收行为
 */
public class GCTest {
	@SuppressWarnings("unused")  // 抑制未使用变量的警告
	public static void main(String[] args) {
        // 声明两个字节数组变量，用于分配内存
		byte[] allocation1, allocation2;
        // 分配约30MB的内存空间（30900 * 1024字节）
		allocation1 = new byte[30900 * 1024];
        // 分配约900KB的内存空间（900 * 1024字节）
		allocation2 = new byte[900 * 1024];
	}
}
