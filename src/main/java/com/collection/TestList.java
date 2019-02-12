package com.collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("1");
		list.add("1");
		list.add("1");
		list.add("1");
		
		System.out.println(list.get(4));
	}
}
