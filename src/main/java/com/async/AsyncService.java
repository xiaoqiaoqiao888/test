package com.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

	@Async
	public AsyncResult<String> hello() throws Exception {

		try {
			Thread.sleep(3000);
			throw new Exception();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AsyncResult<String>("SUCCESS");

	}
}
