package com.zk;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

public class ZKTest01 {
	public static void main(String[] args) throws InterruptedException {
		ZkClient zk = new ZkClient("39.105.8.31:2181", 10000);
		zk.subscribeChildChanges("/", new IZkChildListener() {

			@Override
			public void handleChildChange(String parentPath, List<String> currentChilds) throws Exception {
				System.out.println(parentPath + "'s child changed, currentChilds: " + currentChilds);
			}
		});
		Thread.sleep(Long.MAX_VALUE);
	}
}
