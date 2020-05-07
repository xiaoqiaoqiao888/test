package com.async;

import java.util.concurrent.DelayQueue;

public abstract class AbstractDelayMessage {

	protected static DelayQueue<Message> queue = new DelayQueue<>();

	/**
	 * 再次通知
	 * 
	 * @param message
	 */
	protected void againNotify(Message message) {
		message.increaseNotify();
		queue.add(message);
	}

}