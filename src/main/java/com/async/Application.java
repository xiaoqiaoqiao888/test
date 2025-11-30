package com.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot应用程序的主启动类
 * 使用@SpringBootApplication注解标记这是一个Spring Boot应用程序
 */
@SpringBootApplication
public class Application {
    /**
     * 程序的主入口方法
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 使用SpringApplication的静态run方法启动应用程序
		SpringApplication.run(Application.class, args);
	}
}
