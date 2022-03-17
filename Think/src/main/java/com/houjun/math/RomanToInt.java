package com.houjun.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字 转 拉丁数字
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        if (s == null)
            return 0;
        // 存入所有 枚举项
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int result = 0;
        for (int i = 0; i < s.length(); ) {
            // 先截取两个，判断有没有存在map中，没有的截一个，注意边界
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                result += map.get(s.substring(i, i + 2));
                i = i + 2;
            } else {
                result += map.get(s.substring(i, i + 1));
                ++i;
            }
        }
        return result;
    }
}
