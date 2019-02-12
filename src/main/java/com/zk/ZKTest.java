package com.zk;

import org.I0Itec.zkclient.ZkClient;

public class ZKTest {
	public static void main(String[] args) {
		ZkClient zk = new ZkClient("127.0.0.1:2181", 10000);
		zk.createEphemeral("/1219test");
		zk.createPersistent("/19path/12", true);
		System.out.println("创建成功！！！");

		boolean deleteRecursive = zk.deleteRecursive("/19path");
		System.out.println("删除是否成功：" + deleteRecursive);
	}
}
