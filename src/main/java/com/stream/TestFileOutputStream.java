package com.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestFileOutputStream {
	public static void main(String[] args) {

		try(OutputStream os = new FileOutputStream("E:\\a.txt")) {
			String str = "测试OutputStream!!!22222";

			byte[] bytes = str.getBytes();
			os.write(bytes);
			System.out.println("写入成功！！！");
			os.close();
		} catch (IOException e) {
			System.out.println("写入失败！！！");
		}
	}
}
