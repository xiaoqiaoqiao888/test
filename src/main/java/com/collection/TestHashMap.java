package com.collection;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();

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
		Integer i = 0;
		map.put("k14", i);
		System.out.println(map.get("k14"));
	}
}
