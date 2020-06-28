package com.file;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File file = new File("D:\\ic123");
		boolean mkdirs = file.mkdirs();

		String absolutePath = file.getAbsolutePath();
		System.out.println(mkdirs);
		System.out.println(absolutePath);
	}
}
