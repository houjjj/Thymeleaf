package com.houjun.search;

/**
 * 二分查询
 * 要求入参有序性
 * 不存在返回-1
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 8};
//        System.out.println(search(nums, 9));
        System.out.println(binarylockup(nums, 9));
    }

    public static Integer binarylockup(int[] nums, int target) {
        if (nums.length == 0) {
            return null;
        }
        return binarylockup(nums, 0, nums.length-1, target);
    }

    private static Integer binarylockup(int[] nums, int low, int high, int target) {
        if(low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return binarylockup(nums, low, mid - 1, target);
        } else {
            return binarylockup(nums, mid + 1, high, target);
        }
    }


    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (true){
            int mid = (left+right)/2;
            if(left > right){
                return -1;
            }
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                left = mid+1;
            }
            if(target < nums [mid]){
                right = mid -1;
            }

        }
    }
}
