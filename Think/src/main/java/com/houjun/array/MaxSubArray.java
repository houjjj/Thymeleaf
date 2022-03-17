package com.houjun.array;

/**
 * 最大子序和
 * 解题思路：当下标等于一个任意值时，想要知道加上他后的子序和是不是最大，需要根据加到他的前一个元素子序和来判断，如何加到前一个元素子序和是正数大于0加上他肯定会更大，如果是小于0的负数，那他就该抛弃前面子序，
 * 从他开始新截一个子序列出来，那么到他的子序和应该是其本身
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int [] nums = new int[]{-1,-2,-3};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] num) {
        int length = num.length;
        int[] dp = new int[length];
        //边界条件
        dp[0] = num[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            //转移公式
            dp[i] = Math.max(dp[i - 1], 0) + num[i];
            //记录最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
