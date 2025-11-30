package com.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试ConcurrentHashMap的fail-fast特性
 * 本示例展示在遍历ConcurrentHashMap时删除元素的行为
 */
public class TestConcurrentHashMapFailSafe {
	public static void main(String[] args) {
        // 输出测试标题
		System.out.println("test ConcurrentHashMap fast-fail");
        // 创建一个ConcurrentHashMap实例
		Map<Integer, String> testConcurrentHashMap = new ConcurrentHashMap<Integer, String>();
        // 向Map中添加多个键值对
		testConcurrentHashMap.put(100, "100");
		testConcurrentHashMap.put(200, "200");
		testConcurrentHashMap.put(300, "300");
		testConcurrentHashMap.put(400, "400");
		testConcurrentHashMap.put(500, "500");
        // 输出Map的初始大小
		System.out.println(testConcurrentHashMap.size());
        // 遍历Map中的元素
		for (Map.Entry<Integer, String> entry : testConcurrentHashMap.entrySet()) {
			int key = entry.getKey();
			System.out.println("key=" + key);
            // 当key为300时，从Map中删除该元素
			if (key == 300) {
				testConcurrentHashMap.remove(key);
			}
		}
        // 输出删除元素后的Map大小
		System.out.println(testConcurrentHashMap.size());
        // 再次遍历Map，输出剩余的键值对
		for (Map.Entry<Integer, String> entry : testConcurrentHashMap.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}
}
