package com.houjun.sort;

import java.util.Arrays;

/**
 * 冒泡排序：外层循环从右向左，内层循环从左向右、
 * 难度：一星
 * 复杂度：O(n^2)
 */
public abstract class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 0, 8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            // 内层循环遍历完后，最大的元素会跑到arr[i]
            for (int j = 0; j < i; j++) {
                // 相邻两个元素比较，如果左边元素大于右边元素即降序的话，就交换改成升序
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
