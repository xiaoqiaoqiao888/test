package com.file;

import java.io.File;

/**
 * FileTest类演示了Java中File类的基本使用方法
 * 主要功能是创建目录并获取其绝对路径
 */
public class FileTest {
    /**
     * 程序的入口点
     * @param args 命令行参数
     */
	public static void main(String[] args) {
        // 创建一个File对象，指向D盘下的ic123目录
		File file = new File("D:\\ic123");
        // 尝试创建目录（包括所有必需但不存在的父目录）
		boolean mkdirs = file.mkdirs();

        // 获取文件的绝对路径
		String absolutePath = file.getAbsolutePath();
        // 输出目录是否创建成功
		System.out.println(mkdirs);
        // 输出文件的绝对路径
		System.out.println(absolutePath);
	}
}
