package com.mianshi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wangyi_duplicate {

	public void slove(int[] sequence) {
		// 定义一个链表存放最后结果
		List<Integer> list = new ArrayList<Integer>();
		// 从后往前遍历，保证每种元素保留最后出现的那个
		for (int i = sequence.length - 1; i >= 0; i--) {
			// 如果链表里没有该数字就放入
			if (!list.contains(sequence[i]))
				list.add(sequence[i]);

		}
		// 从后往前遍历
		for (int i = list.size() - 1; i >= 0; i--) {
			if (i > 0)
				System.out.print(list.get(i) + " ");
			else
				System.out.print(list.get(i));
		}
	}

	public static void main(String[] args) {
		// 输入包括两行：
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		// 第一行为序列长度n(1 ≤ n ≤ 50)
		int n = s.nextInt();
		// 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔
		int[] sequence = new int[n];
		for (int i = 0; i < n; i++) {
			sequence[i] = s.nextInt();
		}
		Wangyi_duplicate duplicate = new Wangyi_duplicate();
		duplicate.slove(sequence);

	}
}
