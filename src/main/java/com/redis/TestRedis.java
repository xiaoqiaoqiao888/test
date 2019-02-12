package com.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class TestRedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println("连接成功！！！");
		System.out.println("服务是否运行：" + jedis.ping());
		// String
		jedis.set("k1", "v1");
		System.out.println("set的值为：" + jedis.get("k1"));
		jedis.close();
		System.out.println("-------------------------------------------------");
		// hash
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("xiaoming", "man");
		hashMap.put("xiaohua", "women");
		hashMap.put("xiaoma", "man");
		jedis.hmset("test-hash", hashMap);
		// 获取hash类型缓存数据
		Map<String, String> hashData = jedis.hgetAll("test-hash");
		System.out.println("获取hash缓存数据：" + hashData);
		System.out.println("获取hash缓存数据（xiaoming）：" + hashData.get("xiaoming"));
		System.out.println("获取hash缓存数据（xiaohua）：" + hashData.get("xiaohua"));
		System.out.println("获取hash缓存数据（xiaoma）：" + hashData.get("xiaoma"));
		System.out.println("-------------------------------------------------");
		// 存储List缓存数据
		jedis.lpush("test-list", "Java");
		jedis.lpush("test-list", "PHP");
		jedis.lpush("test-list", "C++");
		// 获取list缓存数据
		List<String> listCache = jedis.lrange("test-list", 0, 3);
		for (int i = 0; i < listCache.size(); i++) {
			System.out.println("缓存输出：" + listCache);
		}

	}
}
