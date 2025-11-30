package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试List操作的类，包含main方法和两个静态方法
 * 用于演示List元素的修改、替换和添加操作
 */
public class TestList {
    /**
     * 程序的主入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 创建一个包含10,20,30,null的ArrayList并赋值给dataList
		List<Integer> dataList = new ArrayList<>(Arrays.asList(10, 20, 30, null));
        // 调用resetList方法处理dataList
		resetList(dataList);
        // 调用setOne方法修改dataList中的元素
		setOne(dataList);
        // 遍历dataList并计算元素的和
		int sum = 0;
		for (Integer integer : dataList) {
			sum += integer;

		}
        // 输出计算结果
		System.out.println(sum);
	}

    /**
     * 将列表中指定索引位置的元素设置为80
     * @param dataList 要修改的列表
     */
	private static void setOne(List<Integer> dataList) {
        // 将列表中索引为3的元素设置为80
		dataList.set(3, 80);
	}

    /**
     * 对列表进行重置操作，包含子列表修改和元素添加
     * @param dataList 要处理的列表
     */
	private static void resetList(List<Integer> dataList) {
		dataList.subList(2, 4).set(0, 50);
		dataList = new ArrayList<Integer>(dataList);
		dataList.add(20);

		System.out.println(dataList);
	}
}
