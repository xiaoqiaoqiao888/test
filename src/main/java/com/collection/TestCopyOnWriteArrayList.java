package com.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 测试CopyOnWriteArrayList类的示例代码
 * CopyOnWriteArrayList是Java并发包中的一个线程安全的List实现
 * 它采用"写时复制"(Copy-On-Write)策略来保证线程安全
 */
public class TestCopyOnWriteArrayList {
	public static void main(String[] args) {
		// 这里使用了COW技术
		String string = "a b c d e";
		List<String> stringList1 = Arrays.asList(string.split(" "));
		List<String> stringList = new CopyOnWriteArrayList<String>(stringList1);
		System.out.println(stringList);

		Iterator<String> iterator = stringList.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals("c")) {
				stringList.remove("c");
				// 会抛 不支持的操作异常 "UnsupportedOperationException"
				// iterator.remove();
			}
		}
		System.out.println(stringList);
	}
}
