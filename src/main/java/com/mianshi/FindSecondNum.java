package com.mianshi;

public class FindSecondNum {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 2, 3, 4, 9, 7, 6, 0 };

		int max;
		int max2;
		if (arr.length < 2) {
			System.out.println("共有一个数值，没有第二大数值");
		}
		if (arr[0] > arr[1]) {
			max = arr[0];
			max2 = arr[1];
		} else {
			max = arr[1];
			max2 = arr[0];
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] > max) {
				max2 = max;
				max = arr[i];
			} else if (arr[i] > max2 && arr[i] < max) {
				max2 = arr[i];
			}
		}
		System.out.println("最大数为：" + max + "  第二大数为：" + max2);
	}
}
