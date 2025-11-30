package com.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * Curator分布式锁测试类
 * 本类演示了如何使用Curator框架实现分布式锁的基本用法
 */
public class TestCurator {
    /**
     * 程序入口方法
     * @param args 命令行参数
     * @throws Exception 可能抛出的异常
     */
	public static void main(String[] args) throws Exception {

		// 创建zookeeper的客户端
        // 设置重试策略：初始重试间隔为1秒，最多重试3次
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

		// 创建Curator客户端，连接到本地ZooKeeper服务器
		CuratorFramework client = CuratorFrameworkFactory.newClient("127.0.0.1:2181", retryPolicy);

		// 启动客户端
		client.start();

		// 创建分布式锁, 锁空间的根节点路径为/curator/lock
        // InterProcessMutex是Curator提供的互斥锁实现
		InterProcessMutex mutex = new InterProcessMutex(client, "/curator/lock");

		// 获取分布式锁，如果获取失败则会重试
		mutex.acquire();

		// 获得了锁, 进行业务流程
		System.out.println("Enter mutex");

		// 完成业务流程, 释放锁
		// 释放锁后，其他等待的客户端可以获取锁
		mutex.release();

		// 关闭客户端，释放资源
		client.close();

	}
}
