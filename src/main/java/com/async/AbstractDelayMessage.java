package com.async;

import java.util.concurrent.DelayQueue;

/**
 * 抽象延迟消息类
 * 该类提供了一个延迟消息队列的基本实现框架
 */
public abstract class AbstractDelayMessage {

	// 保护类型的静态延迟队列，用于存储延迟消息
	protected static DelayQueue<Message> queue = new DelayQueue<>();

	/**
	 * 再次通知方法
	 *  用于将消息重新加入队列，并增加通知次数计数

	 *
	 * @param message 需要重新通知的消息对象
	 */
	protected void againNotify(Message message) {
		// 增加消息的通知次数计数
		message.increaseNotify();
		// 将消息重新添加到延迟队列中
		queue.add(message);
	}

}