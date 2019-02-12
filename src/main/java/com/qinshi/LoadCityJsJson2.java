package com.qinshi;

import java.io.BufferedReader;

/**
 * Copyright 2017 电子计算技术研究所
 * Author：WenLi
 * 创建日期：2018年1月5日
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadCityJsJson2 {
	private static Logger logger = LoggerFactory.getLogger(LoadCityJsJson2.class);

	public static void main(String[] args) {
		List<String> list = getCityCodeAndName();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public static List<String> getCityCodeAndName() {

		List<String> list = new ArrayList<>();
		File file = new File("city.txt");
		// BufferedReader reader = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			logger.info("以行为单位读取文件内容，一次读一行");
			String tempString = null;
			int line = 1;
			// 一次读一行，读入null时文件结束
			while ((tempString = reader.readLine()) != null) {
				CityCodeAndName cityCodeAndName = new CityCodeAndName();
				// 把当前行号显示出来
				logger.info("line " + line + ": " + tempString);
				line++;
				String[] strs = tempString.split("\\|");
				cityCodeAndName.setCode(strs[2]);
				list.add(strs[2]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
