package com.zk;

import java.util.concurrent.CountDownLatch;

import org.I0Itec.zkclient.IZkDataListener;

public class ZkDistributeLock extends ZkAbstractLock {

	@Override
	protected void waitLock() {
		// 监听zk中的/qiao节点
		IZkDataListener iZkDataListener = new IZkDataListener() {

			@Override
			public void handleDataDeleted(String dataPath) throws Exception {
				if (countDownLatch != null) {
					// 线程唤醒
					countDownLatch.countDown();
				}
			}

			@Override
			public void handleDataChange(String dataPath, Object data) throws Exception {

			}
		};
		// 让客户端监听信息
		zkClient.subscribeDataChanges(PATH, iZkDataListener);
		if (zkClient.exists(PATH)) {
			countDownLatch = new CountDownLatch(1);
			try {
				// 线程等待
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 取消监听
		zkClient.unsubscribeDataChanges(PATH, iZkDataListener);
	}

	/**
	 * 创建临时节点成功即认为获取锁成功
	 *
	 * @return
	 */
	@Override
	protected boolean tryLock() {
		try {
			zkClient.createEphemeral(PATH);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
