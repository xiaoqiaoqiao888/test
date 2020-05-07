package com.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
	@Autowired
	private AsyncService asyncService;

	@GetMapping("hello")
	public String hello() {
		return asyncService.hello();
	}
}
