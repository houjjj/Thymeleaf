package com.houjun.math;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5};
        Arrays.sort(nums);
        int rank = rank(nums, 5);
        System.out.println(rank);
        String a="china";
        String substring = a.substring(2, 3);
    }

    public static int rank(int[] nums, int key) {
        int low = 0, high = nums.length - 1, mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
