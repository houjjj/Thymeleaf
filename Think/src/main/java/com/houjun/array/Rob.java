package com.houjun.array;

/**
 * 打家劫舍
 *  dp[] 存储打劫每家的最大获利
 *  判断要不要打劫这家的条件是：这家的金额+(i-2）获利 是否大于 打劫前一家(i-1) ，如果是 dp[i] = dp[i-2]+nums[i],否则dp[i] = dp[i-1]
 *  dp[i] = dp[i-1] 的意思是打劫到i家金额不如打劫 dp[i-1]家
 *
 *  关系式：当前房屋偷加上 上上家偷的 和这次不偷即上家偷过后的总金额 作比较，取最大值
 */
public class Rob {

    public static void main(String[] args) {
        int[] ints = {2, 1, 1, 2};
        System.out.println(rob(ints));
    }

    public static int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Math.max(nums[0],nums[1]);
        // dp[1] 上的最大金额应该是nums[0] 和 nums[1] 之间的最大值
        dp[1] = max;
        // dp[i] 上保存到i时最大可偷金额
        for(int i = 2; i < nums.length; i++){
            // 转移公式：挑选当前i元素金额+ （i-2）最大可偷 和 前一个i-1 最大可偷 之中的最大值，赋给dp[i]
            // 作为dp[i] 的值
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
            // 记录最大值
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
