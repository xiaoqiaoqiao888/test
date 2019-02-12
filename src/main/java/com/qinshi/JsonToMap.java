package com.qinshi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonToMap {

	public static void main(String[] args) throws JSONException {
		List<String> strings = getStrings();

		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
	}

	// 4000
	public static List<String> getStrings() throws JSONException {

		List<String> lists = new ArrayList<>();
		File file = new File("station_city.js");
		// BufferedReader reader = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			System.out.println("以行为单位读取文件内容，一次读一行");
			String tempString = null;
			int line = 1;
			// 一次读一行，读入null时文件结束
			while ((tempString = reader.readLine()) != null) {
				// 把当前行号显示出来
				System.out.println("line " + line + ": " + tempString);
				line++;
				JSONObject obj = new JSONObject("{" + tempString + "}");
				Stack<JSONObject> stObj = new Stack<JSONObject>();
				stObj.push(obj);
				JSONObject json = stObj.pop();
				@SuppressWarnings("unchecked")
				Iterator<String> it = json.keys();
				while (it.hasNext()) {
					String key = it.next();
					lists.add(key);
					// 得到value的值
					// Object value = json.get(key);
					// resultMap.put(key, value);
					// System.out.println(resultMap);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lists;
	}
}
