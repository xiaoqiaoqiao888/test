package com.zk;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * Zookeeper base学习笔记
 */
public class ZookeeperBase {

	/** zookeeper地址 */
	static final String CONNECT_ADDR = "127.0.0.1:2181";
	/** session超时时间 */
	static final int SESSION_OUTTIME = 10000;// ms
	/** 信号量，阻塞程序执行，用于等待zookeeper连接成功，发送成功信号 */
	static final CountDownLatch connectedSemaphore = new CountDownLatch(1);

	public static void main(String[] args) throws Exception {

		ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				// 获取事件的状态
				KeeperState keeperState = event.getState();

				// 获取事件的类型
				EventType eventType = event.getType();
				// 如果是建立连接
				if (KeeperState.SyncConnected == keeperState) {
					if (EventType.None == eventType) {
						// 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
						System.out.println("zk 建立连接");
						connectedSemaphore.countDown();
					}
				}
			}
		});

		// 进行阻塞
		connectedSemaphore.await();

		System.out.println("-----------------------------------------------------------------");
		// 创建父节点
		if (zk.exists("/testRoot", true) == null) {
			String create = zk.create("/testRoot", "father data".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.PERSISTENT_SEQUENTIAL);
			System.out.println("创建父节点：" + create);
		} else {
			System.out.println("父节点已存在");
		}

		// 创建子节点
		if (zk.exists("/testRoot/children", true) == null) {
			String create = zk.create("/testRoot/children", "children data".getBytes(), Ids.OPEN_ACL_UNSAFE,
					CreateMode.EPHEMERAL);
			System.out.println("创建子节点：" + create);
		} else {
			System.out.println("子节点已存在");
		}
		// 临时节点创建不了子节点
		// if (zk.exists("/testRoot/children/greatson", true) == null) {
		// String create = zk.create("/testRoot/children/greatson", "greatson
		// data".getBytes(), Ids.OPEN_ACL_UNSAFE,
		// CreateMode.EPHEMERAL);
		// System.out.println("创建孙子节点" + create);
		// } else {
		// System.out.println("孙子节点已存在");
		// }
		// 获取节点信息
		byte[] data = zk.getData("/testRoot", false, null);
		System.out.println(new String(data));
		System.out.println("获取子节点信息：" + zk.getChildren("/testRoot", false));

		// 修改节点的值
		zk.setData("/testRoot", "modify data root".getBytes(), -1);
		byte[] data1 = zk.getData("/testRoot", false, null);
		System.out.println("修改父节点的值：" + new String(data1));
		// 判断节点是否存在
		System.out.println("删除子节点前的值为：" + zk.exists("/testRoot/children", false));
		// 删除节点
		// zk.delete("/testRoot/children", -1, new AsyncCallback.VoidCallback() {
		//
		// @Override
		// public void processResult(int rc, String path, Object ctx) {
		// System.out.println("rc: " + rc);
		// System.out.println("path: " + path);
		// System.out.println("ctx: " + ctx);
		// }
		// }, "AAA");
		// System.out.println("删除子节点后的值为：" + zk.exists("/testRoot/children", false));

		// zk.close();

	}
}