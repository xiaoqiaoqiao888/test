package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Java堆内存溢出的示例类
 * 该类通过不断创建对象并添加到列表中，最终会导致堆内存溢出错误(OutOfMemoryError)
 */
public class TestOutOfMemoryError {
    /**
     * 程序入口点
     * @param args 命令行参数（本程序中未使用）
     */
	public static void main(String[] args) {
        // 创建一个ArrayList用于存储TestOutOfMemoryError对象
		List<TestOutOfMemoryError> list = new ArrayList<>();
        // 无限循环，不断创建新的TestOutOfMemoryError对象并添加到列表中
        // 这将导致堆内存逐渐耗尽，最终抛出OutOfMemoryError
		while (true) {
			list.add(new TestOutOfMemoryError());
		}
	}
}
