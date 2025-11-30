package com.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试HashMap的类
 * 该类演示了HashMap的基本使用方法，包括创建Map、添加键值对以及获取值
 */
public class TestHashMap {
    /**
     * 程序的主入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 创建一个HashMap实例，键为String类型，值为Object类型
		Map<String, Object> map = new HashMap<>();

        // 向Map中添加多个键值对
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v1");
		map.put("k4", "v1");
		map.put("k5", "v1");
		map.put("k6", "v1");
		map.put("k7", "v1");
		map.put("k8", "v1");
		map.put("k9", "v1");
		map.put("k10", "v1");
		map.put("k11", "v1");
		map.put("k12", "v1");
		map.put("k13", "v1");
        // 创建一个Integer对象并添加到Map中
		Integer i = 0;
		map.put("k14", i);
        // 获取并打印键"k14"对应的值
		System.out.println(map.get("k14"));
	}
}
