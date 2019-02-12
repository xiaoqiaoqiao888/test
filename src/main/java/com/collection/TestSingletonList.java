package com.collection;

import java.util.Collections;
import java.util.List;

public class TestSingletonList {
	public static void main(String[] args) {

		List<String> list = Collections.singletonList("data");
//		list.add("a");
		System.out.println(list);
	}
}
