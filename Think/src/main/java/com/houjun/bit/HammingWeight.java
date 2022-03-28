package com.houjun.bit;

public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }


    public static int hammingWeight(int n) {
        int count = 0;
        // 每次把n 和 1 （..0001），做与运算，结果为1，说明n的二进制的最小位上是一，然后n 右移
        while (n != 0) {
            //
            if ((n & 1) == 1) {
                ++count;
            }
            n = n >>> 1;
        }
        return count;
    }
}
