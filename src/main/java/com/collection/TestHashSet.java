package com.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试HashSet类的使用示例
 * HashSet是基于HashMap实现的，不保证元素的顺序，且不允许有重复元素
 */
public class TestHashSet {
    /**
     * 程序入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 创建一个HashSet集合，用于存储String类型的元素
		Set<String> set = new HashSet<>();
        // 向集合中添加元素，注意添加了两个"s"，但HashSet会自动去重
		set.add("q");
		set.add("c");
		set.add("b");
		set.add("t");
		set.add("s");
		set.add("s");
		set.add("u");
        // HashSet允许添加null值
		set.add(null);

        // 打印集合内容，输出结果将显示所有不重复的元素，包括一个null值
		System.out.println(set);
	}
}
