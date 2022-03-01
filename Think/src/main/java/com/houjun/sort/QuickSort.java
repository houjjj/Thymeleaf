package com.houjun.sort;

/**
 * 快速排序：选定一个元素作为轴，比他小的都放到左边，比他大的都放到有右边，然后递归
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 0, 8};
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int array[], int low, int high) {
        int pivot, p_pos;
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (int i = low + 1; i < high; i++) {
                if (array[i] > pivot) {

                }
            }
        }
    }
}
