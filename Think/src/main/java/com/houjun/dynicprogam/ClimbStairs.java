package com.houjun.dynicprogam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 经典爬楼梯问题
 */
public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs3(45));
    }

    static Map<Integer, Integer> cache = new HashMap<>();
    static List<Integer> cache2 = new ArrayList<>();

    static {
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);
    }

    static {
        cache2.add(0);
        cache2.add(1);
        cache2.add(2);
    }

    // 方法一：递归解法。用Map 做缓存
    public static int climbStairs(int n) {
        // 方法一：递归 ,列举n 从0到5，可知f(n)结果呈斐波那契数列分布
        // 递归关系 f(n) = f(n-1) + f(n-2)
        // 退出条件：n <= 2 时，返回n
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        cache.put(n, result);
        return result;
    }

    // 方法一：递归解法。 用List做缓存
    public static int climbStairs2(int n) {
        // 方法一：递归 ,列举n 从0到5，可知f(n)结果呈斐波那契数列分布
        // 递归关系 f(n) = f(n-1) + f(n-2)
        // 退出条件：n <= 2 时，返回n
        if (cache2.size() - 1 >= n) {
            return cache2.get(n);
        }
        int result = climbStairs2(n - 1) + climbStairs2(n - 2);
        cache2.add(result);
        return result;
    }

    /**
     * 方法二：动态规划
     *
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        // 定义动态规划中间用到的变量
        int a = 1, b = 2, res = 0;
        // 边界条件不变
        if (n <= 2) {
            return n;
        }
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
