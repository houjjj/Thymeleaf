package com.houjun.sort;

import java.util.Arrays;

/**
 * 插入排序：
 * 难度  一星
 * 复杂度 ： O(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 0, 8};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] array) {
        // 外层循环遍历的每一个值，需要和前面已经排好的进行对比
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
