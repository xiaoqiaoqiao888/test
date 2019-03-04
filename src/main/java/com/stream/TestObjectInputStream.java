package com.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class TestObjectInputStream {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream("F:\\a.txt");
		ObjectInputStream ois = new ObjectInputStream(is);
		Person person = (Person) ois.readObject();
		System.out.println("反序列化后的数据为：" + person);
		ois.close();

	}
}
