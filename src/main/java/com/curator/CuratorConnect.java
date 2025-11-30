package com.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * CuratorConnect类
 * 用于创建和管理Curator客户端与ZooKeeper的连接
 */
public class CuratorConnect {
	// Curator客户端实例
	public CuratorFramework client = null;
	// 集群模式则是多个ip
	private static final String zkServerIps = "127.0.0.1:2181";

	public CuratorConnect() {
		/**
		 * 同步创建zk示例，原生api是异步的 这一步是设置重连策略
		 *
		 * ExponentialBackoffRetry构造器参数： curator链接zookeeper的策略:ExponentialBackoffRetry
		 * baseSleepTimeMs：初始sleep的时间 maxRetries：最大重试次数 maxSleepMs：最大重试时间
		 */
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);

		// 实例化Curator客户端，Curator的编程风格可以让我们使用方法链的形式完成客户端的实例化
		client = CuratorFrameworkFactory.builder() // 使用工厂类来建造客户端的实例对象
				.connectString(zkServerIps) // 放入zookeeper服务器ip
				.sessionTimeoutMs(10000).retryPolicy(retryPolicy) // 设定会话时间以及重连策略
				.build(); // 建立连接通道

		// 启动Curator客户端
		client.start();
	}

	// 关闭zk客户端连接
	private void closeZKClient() {
		if (client != null) {
			this.client.close();
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// 实例化
		CuratorConnect curatorConnect = new CuratorConnect();
		// 获取当前客户端的状态
		boolean isZkCuratorStarted = curatorConnect.client.isStarted();
		System.out.println("当前客户端的状态：" + (isZkCuratorStarted ? "连接中..." : "已关闭..."));

		Thread.sleep(1000);

		// 关闭客户端
		curatorConnect.closeZKClient();

		// 获取当前客户端的状态
		isZkCuratorStarted = curatorConnect.client.isStarted();
		System.out.println("当前客户端的状态：" + (isZkCuratorStarted ? "连接中..." : "已关闭..."));
	}
}
