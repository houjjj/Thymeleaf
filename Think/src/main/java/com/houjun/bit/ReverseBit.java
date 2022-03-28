package com.houjun.bit;

/**
 *
 */
public class ReverseBit {
    public static void main(String[] args) {
        int x = reverseBits(-3);
        System.out.println(Integer.toBinaryString(x));
        System.out.println( (x));
        System.out.println(0 << 1);
        byte b = -128;
        byte b1 = 127;
        
    }

    public static int reverseBits(long n) {
        int result = 0;
        // 保证循环32次
        for (int i = 0; i < 32; i++) {
            // result 先左移一位，把最后一位空出来，用来存放n的最后一位
            result <<= 1;
            // result 加上n的最后一位
            result += n&1;
            // n 往右移一位，把最后一位数字去掉
            n = n >>  1;
        }
        return result;
    }
}
