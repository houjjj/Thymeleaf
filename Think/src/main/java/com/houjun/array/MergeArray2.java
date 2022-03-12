package com.houjun.array;

import java.util.Arrays;

/**
 * 合并数组二
 */
public class MergeArray2 {
    public static void main(String[] args) {
        int[] a, b;
        a = new int[]{1, 2, 3, 0, 0, 0};
        b = new int[]{2, 5, 6};
        merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 从m-1，n-1的下标开始比对，大的值放到最后的空白处，指针向左移动
     * 做这种题，先在纸上模拟一下流程
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        // 如果是j < 0,则nums1是最终返回状态
        // 如果是i < 0,则nums2可能还没有遍历完，存在未处理的元素，nums1左边的元素都已经被放到了后面
        while(j >= 0){
            // 无脑把nums2上的值往nums1上的空闲地方上加
            nums1[k--] = nums2[j--];
        }
    }
}
