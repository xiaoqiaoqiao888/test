package com.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步控制器类
 * 使用@RestController注解标记这是一个RESTful控制器
 */
@RestController
public class AsyncController {
    /**
     * 自动注入异步服务接口
     * 使用@Autowired注解实现依赖注入
     */
	@Autowired
	private AsyncService asyncService;

    /**
     * 处理GET请求的hello方法
     * 映射到"/hello"路径
     * @return 返回异步调用的结果字符串
     * @throws Exception 可能抛出异常
     */
	@GetMapping("hello")
	public String hello() throws Exception {
        // 调用异步服务的hello方法，获取异步结果
		 AsyncResult<String> hello = asyncService.hello();
        // 获取异步结果并返回
		 return hello.get();
	}
}
