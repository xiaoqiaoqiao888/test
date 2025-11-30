package com.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * InterProcessMutex：分布式可重入排它锁 InterProcessSemaphoreMutex：分布式排它锁
 * InterProcessReadWriteLock：分布式读写锁 InterProcessMultiLock：将多个锁作为单个实体管理的容器
 * 
 * @author qiaodongjie
 * @date 2018年12月10日 上午8:50:14
 *
 */
public class CuratorAPI {
    // 定义ZooKeeper连接地址常量
	public static final String CONN_ADDR = "127.0.0.1:2181";
    // 定义会话超时时间常量，单位为毫秒
	public static final int SESSION_TIMEOUT = 2000;

	public static void main(String[] args) {
		// 重试策略
		RetryPolicy retry = new ExponentialBackoffRetry(1000, 3);
		// 建立连接
		CuratorFramework client = CuratorFrameworkFactory.newClient(CONN_ADDR, retry);
		client.start();
		System.out.println("zookeeper 已启动------------------------------------------------------");
		// 创建一个节点
		try {
			if (client.checkExists().forPath("/testCurator") == null) {
				String forPath = client.create().forPath("/testCurator", "curator".getBytes());
				System.out.println("创建节点的路径为：" + forPath);
			} else {
				System.out.println("/testCurator节点已经存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
