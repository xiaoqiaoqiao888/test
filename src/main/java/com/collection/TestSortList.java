package com.collection;

import java.util.ArrayList;
import java.util.List;

public class TestSortList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("1");
		list.add("4");
		list.add("6");
		list.add("3");
		list.add("9");
		list.add("0");
		list.add("5");
		list.sort(null);
		System.out.println(list);
	}
}
