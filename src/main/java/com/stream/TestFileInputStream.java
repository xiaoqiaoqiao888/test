package com.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStream {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("F:\\home\\jcala\\xmarket\\log\\spring_log\\spring.log");
		int size = is.available();
		System.out.println("可以读取文件的大小：" + size);
		char[] ch = new char[size];
		for (int i = 0; i < size; i++) {
			ch[i] = (char) is.read();
			System.out.println(ch[i]);
		}
		is.close();
	}
}
