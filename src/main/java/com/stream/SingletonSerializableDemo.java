package com.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonSerializableDemo {
	// 为了便于理解，忽略关闭流操作及删除文件操作。真正编码时千万不要忘记
	// Exception直接抛出
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Write Obj to file
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
		oos.writeObject(Singleton.getSingleton());
		oos.close();
		// Read Obj from file
		File file = new File("tempFile");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Singleton newInstance = (Singleton) ois.readObject();
		ois.close();
		// 判断是否是同一个对象
		System.out.println(newInstance == Singleton.getSingleton());
	}
}
