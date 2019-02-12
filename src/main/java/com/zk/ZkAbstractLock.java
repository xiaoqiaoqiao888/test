package com.zk;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.ZkClient;

public abstract class ZkAbstractLock implements Lock {
	private static final String CONNECT_ADDR = "127.0.0.1:2181";
	/**
	 * 分布式环境下，每个应用节点都作为一个zk客户端
	 */
	protected ZkClient zkClient = new ZkClient(CONNECT_ADDR);

	/**
	 * 在zookeeper中创建的节点名称
	 */
	protected static final String PATH = "/qiao";
	/**
	 * 计数器
	 */
	protected CountDownLatch countDownLatch;

	@Override
	public void getLock() {
		if (tryLock()) {
			System.out.println("--------获取锁成功--------");
		} else {
			System.out.println("--------等待锁--------");
			waitLock();
			System.out.println("-------等待线程唤醒--------");
			getLock();
		}
	}

	protected abstract void waitLock();

	protected abstract boolean tryLock();

	@Override
	public void unLock() {
		if (zkClient != null) {
			zkClient.close();
		}
		System.out.println("--------释放锁成功--------");
	}
}
