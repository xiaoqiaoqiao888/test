package com.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 * 异步服务类，使用@Service注解标记为Spring服务组件
 * 该类提供了异步执行的方法示例
 */
@Service
public class AsyncService {

    /**
     * 异步执行的方法，使用@Async注解标记
     * 该方法模拟了一个耗时操作，并返回AsyncResult<String>类型的结果
     *
     * @return 返回AsyncResult<String>类型的结果对象
     * @throws Exception 可能抛出异常
     */
	@Async
	public AsyncResult<String> hello() throws Exception {

        // 尝试执行耗时操作
		try {
            // 线程休眠3秒，模拟耗时操作
			Thread.sleep(3000);
            // 抛出异常
			throw new Exception();
		} catch (InterruptedException e) {
            // 打印异常堆栈信息
			e.printStackTrace();
		}
        // 返回异步结果对象
		return new AsyncResult<String>("SUCCESS");

	}
}
