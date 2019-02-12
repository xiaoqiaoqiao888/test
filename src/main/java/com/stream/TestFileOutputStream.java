package com.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFileOutputStream {
	public static void main(String[] args) {
		OutputStream os;
		try {
			String str = "测试OutputStream!!!22222";

			byte[] bytes = str.getBytes();
			os = new FileOutputStream("F:\\a.text");
			os.write(bytes);
			System.out.println("写入成功！！！");
			os.close();
		} catch (IOException e) {
			System.out.println("写入失败！！！");
		}
	}
}
