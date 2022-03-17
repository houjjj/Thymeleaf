package com.houjun.design;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱数组
 */
public class Shuffle {
    private int[] nums;

    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5};
        Shuffle shuffle = new Shuffle(nums);
        System.out.println(Arrays.toString(shuffle.shuffle()));
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Random r = new Random();
        int[] shuffle = Arrays.copyOf(nums, nums.length);
        for (int i = shuffle.length - 1; i >= 1; i--) {
            // 为啥这里不能是nextInt(i) 因为打乱后有可能没变啊
            int j = r.nextInt(i+1);
            int temp = shuffle[i];
            shuffle[i] = shuffle[j];
            shuffle[j] = temp;
        }
        return shuffle;
    }
}
