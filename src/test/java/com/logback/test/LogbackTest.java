package com.logback.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
	private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

	public static void main(String[] args) {
		logger.debug("logback 成功了");
		logger.info("logback 成功了");
		logger.error("logback 成功了");
	}
}
