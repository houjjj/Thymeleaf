package com.houjun.sort;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * 快速排序：选定一个元素作为轴，比他小的都放到左边，比他大的都放到有右边，然后递归
 */
public class QuickSort {

    public static void main(String[] args) {
//        int[] arr = {1, 3, 2, 5, 0, 8};
        int[] arr = {1,  5, 8,7,2,4,3};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
//        HashMap<Object, Object> hashMap = new HashMap<>();
//        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put("c",null);
//        hashMap.put("a",null);

    }

    public static void quickSort(int[] array, int low, int high) {
        int pivot, p_pos, t;
        if (low < high) {
            p_pos = low;
            // 选一个基准值
            pivot = array[p_pos];
            for (int i = low + 1; i <= high; i++) {
                if (array[i] < pivot) {
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = t;
                }
            }
            // 把基准值放到p_pos 所在的下标上,这样基准值左边的一定比基准值小，右边的一定比他大，
            // p_pos 在本层递归自增几次，说明基准值右面有几个值小于他
            t = array[low];
            array[low] = array[p_pos];
            array[p_pos] = t;
            quickSort(array, low, p_pos - 1);
            quickSort(array, p_pos + 1, high);
        }
    }
}
