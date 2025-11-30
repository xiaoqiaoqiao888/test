package com.collection;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List; // 需要导入List接口和ArrayList类
/**
 * 测试列表排序的类
 * 该类演示了如何创建一个字符串列表并对其进行排序
 */
public class TestSortList {
    /**
     * 程序的主入口方法
     * @param args 命令行参数，在此示例中未使用
     */
	public static void main(String[] args) {
        // 创建一个ArrayList<String>对象来存储字符串元素
		List<String> list = new ArrayList<>();



        // 向列表中添加元素
		list.add("1");  // 添加字符串"1"
		list.add("4");  // 添加字符串"4"
		list.add("6");  // 添加字符串"6"
		list.add("3");  // 添加字符串"3"
		list.add("9");  // 添加字符串"9"
		list.add("0");  // 添加字符串"0"
		list.add("5");  // 添加字符串"5"
        // 使用自然排序对列表进行排序
        // 参数为null表示使用元素的自然顺序进行排序
		list.sort(null);
        // 打印排序后的列表
		System.out.println(list);
	}
}
