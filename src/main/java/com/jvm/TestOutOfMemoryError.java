package com.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestOutOfMemoryError {
	public static void main(String[] args) {
		List<TestOutOfMemoryError> list = new ArrayList<>();
		while (true) {
			list.add(new TestOutOfMemoryError());
		}
	}
}
