package com.collection;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("q");
		set.add("c");
		set.add("b");
		set.add("t");
		set.add("s");
		set.add("s");
		set.add("u");
		set.add(null);

		System.out.println(set);
	}
}
