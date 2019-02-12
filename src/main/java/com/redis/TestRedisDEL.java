package com.redis;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class TestRedisDEL {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		System.out.println(jedis.ping());
		System.out.println("redis连接成功！！！");
		Set<String> keys = jedis.keys("*");
		List<String> list = keys.stream().collect(Collectors.toList());
		Pipeline pipelined = jedis.pipelined();
		long start = System.currentTimeMillis();
		System.out.println("删除开始时间：" + start);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			pipelined.del(list.get(i));
		}
		pipelined.sync();

		long end = System.currentTimeMillis();
		System.out.println("删除数据耗时：" + (end - start));
		// jedis.close();
	}
}
