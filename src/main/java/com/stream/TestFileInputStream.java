package com.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestFileInputStream {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream(".classpath");
		int size = is.available();
		System.out.println("可以读取文件的大小：" + size);
		// char[] ch = new char[size];
		// for (int i = 0; i < size; i++) {
		// ch[i] = (char) is.read();
		// System.out.print(ch[i]);
		// }
		int len = 0;
		while ((len = is.read()) != -1) {
			System.out.print((char) len);
		}
		is.close();
	}
}
