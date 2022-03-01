package com.houjun.sort;

import java.util.Arrays;

/**
 * 选择排序 ：
 * 难度：1星
 * 复杂度：O(n^2)
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 0, 8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] array) {
        // 遍历，外层循环每一次执行完，都能确定相应下标上的值是其后面剩余元素的最小值
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                // 如果arr[j] 比min还小，就把他和arr[i]交换并设置min为他
                if (array[j] < min) {
                    min = array[j];
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
