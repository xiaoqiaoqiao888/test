package com.async;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 延迟执行的消息类，实现了Delayed接口，用于支持延迟队列功能
 * 
 * @author K. L. Mao
 * @create 2018/12/19
 */
public class Message implements Delayed {

	private static final String ROUTER_SUCCESS_CODE = "ROUTE_0000";

	// 单位 秒
	private static final int[] delayTimeArray = { 0, 3, 15, 60, 300, 600, 900, 900, 900, 900 };

	private static final int TIME_UNIT = 1000;

	// 支付流水号
	private String orderNo;
	// 通知数组下标
	private int notifyIndex;
	// 执行时间 纳秒
	private long activeTime;
	// 结果码
	private String resultCode;

	public String getOrderNo() {
		return orderNo;
	}

	public int getNotifyIndex() {
		return notifyIndex;
	}

	public long getActiveTime() {
		return activeTime;
	}

	public String getResultCode() {
		return resultCode;
	}

	public Message() {
	}

	public Message(String orderNo) {
		this(orderNo, ROUTER_SUCCESS_CODE);
	}

	public Message(String orderNo, String resultCode) {
		this.orderNo = orderNo;
		this.resultCode = resultCode;
		this.activeTime = System.currentTimeMillis() + delayTimeArray[notifyIndex] * TIME_UNIT;
	}

	/**
	 * 递增通知次数
	 */
	public void increaseNotify() {
		notifyIndex++;
		this.activeTime = System.currentTimeMillis() + delayTimeArray[notifyIndex] * TIME_UNIT;
	}

	public int getArrayLength() {
		return delayTimeArray.length;
	}

	/**
	 * 方法返回一个小于等于 0 的值时,将发生到期
	 * 
	 * @param unit
	 * @return
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		return this.activeTime - System.currentTimeMillis();
	}

	/**
	 * 队列元素根据执行时间的大小正序排列，即执行时间最小的在队首
	 * 
	 * @param delayed
	 * @return
	 */
	@Override
	public int compareTo(Delayed delayed) {
		Message msg = (Message) delayed;
		long timeout = this.activeTime - msg.getActiveTime();
		return timeout > 0 ? 1 : timeout < 0 ? -1 : 0;
	}

}
