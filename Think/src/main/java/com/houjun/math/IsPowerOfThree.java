package com.houjun.math;

public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(Math.pow(3, 5));
        System.out.println(isPowerOfThree2(243));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        double d = Math.log10(n) / Math.log10(3);
        return d == (int) d;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree2(n / 3)));
    }
}
