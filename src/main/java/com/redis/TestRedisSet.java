package com.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestRedisSet {
	public static void main(String[] args) throws UnknownHostException, IOException {
		@SuppressWarnings("resource")
		Socket socket = new Socket("127.0.0.1", 6379);
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		os.write("set k2 v2\r\n".getBytes());
		byte[] b = new byte[2048];
		int len = is.read(b);
		System.out.println(new String(b, 0, len));
		// socket.close();

		System.out.println("------------------------------------------------------");
		String key = "key";
		String value = "value";
		StringBuffer sb = new StringBuffer();
		sb.append("*3").append("\r\n");
		sb.append("$3").append("\r\n");
		sb.append("set").append("\r\n");
		// key
		sb.append("$").append((key.getBytes()).length).append("\r\n");
		sb.append("key").append("\r\n");
		// value
		sb.append("$").append((value.getBytes()).length).append("\r\n");
		sb.append("value").append("\r\n");
		os.write(sb.toString().getBytes());
		byte[] res = new byte[2048];
		if (is.read() == '+') {
			int read = is.read(res);
			System.out.println(new String(res, 0, read));
		}
	}
}
