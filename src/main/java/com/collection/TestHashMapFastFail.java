package com.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的快速失败(fast-fail)机制的示例类
 * 当在迭代过程中修改HashMap的结构时，会抛出ConcurrentModificationException异常
 */
public class TestHashMapFastFail {
	public static void main(String[] args) {
		System.out.println("test HashMap fast-fail");
        // 创建一个HashMap实例并添加一些键值对
		Map<Integer, String> testHashMap = new HashMap<Integer, String>();
		testHashMap.put(1000, "1000");
		testHashMap.put(2000, "2000");
		testHashMap.put(3000, "3000");
		testHashMap.put(4000, "4000");
		testHashMap.put(5000, "5000");
        // 打印HashMap的大小
		System.out.println(testHashMap.size());
        // 遍历HashMap并尝试在迭代过程中删除元素
		for (Map.Entry<Integer, String> entry : testHashMap.entrySet()) {
			int key = entry.getKey();
			System.out.println("key=" + key);
			if (key == 3000) {
				testHashMap.remove(key); // 这行代码会触发快速失败机制
			}
		}
        // 打印修改后的HashMap大小
		System.out.println(testHashMap.size());
        // 再次遍历HashMap打印所有键值对
		for (Map.Entry<Integer, String> entry : testHashMap.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}
}