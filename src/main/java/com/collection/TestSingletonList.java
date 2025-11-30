package com.collection;

import java.util.Collections;
import java.util.List;

import java.util.Collections;
import java.util.List;
/**
 * 测试单例列表的示例类
 * 使用Collections.singletonList()创建一个不可变的单元素列表
 */
public class TestSingletonList {
    /**
     * 程序的主入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {

        // 使用Collections.singletonList()创建一个包含单个元素的不可变列表
		List<String> list = Collections.singletonList("data");
        // 下面这行代码被注释掉了，因为尝试向不可变列表添加元素会抛出UnsupportedOperationException异常
//		list.add("a");
        // 打印列表内容
		System.out.println(list);
	}
}
