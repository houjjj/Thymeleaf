package com.houjun.math;

/**
 * 两数乘积=最大公约数*最小公倍数
 */
public class LowestCommonMultiple {
    public static void main(String[] args) {
        System.out.println(lcm(25, 50));
    }

    /**
     * 最小公倍数 The Lowest Common Multiple
     *
     * @param p
     * @param q
     * @return
     */
    public static int lcm(int p, int q) {
        int mul = p * q;
        // 0 不能做除数
        while(q != 0){
            int r = p % q;
            p = q;
            q = r;
        }
        return mul/p;
    }
}
