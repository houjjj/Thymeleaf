package com.houjun.math;

/**
 * 欧几里得算法
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        System.out.println(gcd(1234567818, 24));
        System.out.println(gcd2(1234567818, 24));
    }

    /**
     * 最大公约数 Greatest Common Divisor
     * @param p
     * @param q
     * @return
     */
    public static int gcd(int p,int q){
        if(q==0)return p;
        int r = p % q;
        return gcd(q,r);
    }

    /**
     * 最大公约数 Greatest Common Divisor
     * @param p
     * @param q
     * @return
     */
    public static int gcd2(int p,int q){
        // 0 不能做除数
        while(q != 0){
            int r = p % q;
            p = q;
            q = r;
        }
        return p;
    }


}
