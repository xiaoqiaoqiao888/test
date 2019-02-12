package com.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestRedisSocket {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 6379);
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		os.write("PING\r\n".getBytes());
		byte[] b = new byte[2048];
		if (is.read() == '+') {
			int len = is.read(b);
			System.out.println(new String(b, 0, len));
			socket.close();
		}
	}
}
