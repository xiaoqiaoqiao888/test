package com.other;


import java.util.Arrays;

public class Sort {

    /**
     * 主方法，程序的入口点
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 初始化一个整型数组
        int[] arr = {1, 5, 4, 8, 16, 9, 6, 64, 3, 0};
        // 打印排序提示信息
        System.out.println("从小到大排序");
        // 使用Arrays类的sort方法对数组进行排序
        Arrays.sort(arr);
        // 使用增强for循环遍历排序后的数组
        for (int i : arr) {
            // 打印数组元素，并在每个元素后添加逗号
            System.out.print(i + ",");
        }

    }
}
