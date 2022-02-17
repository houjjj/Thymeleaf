package com.houjun.array;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 10};
        int[] b = {2, 4, 6, 8, 9};
        int[] result = merge(a, b);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 合并两个有序数组
     *
     * @param a
     * @param b
     * @return
     */
    private static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int alen = a.length, blen = b.length, length = alen + blen;
        int[] result = new int[length];
        while (i < alen && j < blen) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i != alen) {
            result[k++] = a[i++];
        }
        while (j != blen) {
            result[k++] = b[j++];
        }
        return result;
    }
}
