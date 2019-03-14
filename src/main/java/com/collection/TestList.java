package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<Integer> dataList = new ArrayList<>(Arrays.asList(10, 20, 30, null));
		resetList(dataList);
		setOne(dataList);
		int sum = 0;
		for (Integer integer : dataList) {
			sum += integer;

		}
		System.out.println(sum);
	}

	private static void setOne(List<Integer> dataList) {
		dataList.set(3, 80);
	}

	private static void resetList(List<Integer> dataList) {
		dataList.subList(2, 4).set(0, 50);
		dataList = new ArrayList<Integer>(dataList);
		dataList.add(20);

		System.out.println(dataList);
	}
}
