package com.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TestObjectOutputStream {
	public static void main(String[] args) throws IOException {
		OutputStream op = new FileOutputStream("F:" + File.separator + "a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(op);
		// oos.writeObject(new Person(1, "王小二", 180));
		oos.write(-28);
		oos.write(-67);
		// byte b[]=new byte[] {0,1,2,5,6,99};
		// oos.write(b, 0, 1);
		System.out.println("序列化成功！！！");
		oos.flush();
		oos.close();
	}
}

@Data
@AllArgsConstructor
class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private double height;
}