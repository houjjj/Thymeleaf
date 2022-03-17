package com.houjun.math;

import java.util.Arrays;

/**
 * 计算质数
 */
public class CaculPrime {
    public static void main(String[] args) {
        CaculPrime prime = new CaculPrime();
        System.out.println(prime.countPrimes2(5000000));
    }

    /**
     * 方法一：暴力破解
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) {
                ++sum;
            }
        }
        return sum;
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃氏筛法
     * 核心思想：找到范围内所有合数，剩下的就是质数
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        answer[0] = 0;
        answer[1] = 0;
        for (int i = 2; i * i < n; i++) {
            if (answer[i] == 0) {
                continue;
            }
            for (int k = i * i; k < n; k += i) {
                // 合数设置成0
                answer[k] = 0;
            }
        }
        int sum = 0;
        for (int i : answer) {
            sum += i == 1 ? 1 : 0;
        }
        return sum;
    }
}
