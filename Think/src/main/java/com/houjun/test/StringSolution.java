package com.houjun.test;

public class StringSolution {
    public static void main(String[] args) {
//        System.out.println(strStr2("a", "a"));
        System.out.println(kmp1("BBC ABCDAB ABCDABCDABDE", "ABCDAB"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (j < needle.length() && i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i <= n - m; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static int kmp(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        // 部分匹配表
        int[] pi = new int[m];
        // j是前缀末尾位，j是后缀末尾位
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static int kmp1(String str, String patter) {
        int slen = str.length(), plen = patter.length();
        int[] next = new int[plen];
        if (plen == 0) {
            return 0;
        }
        for (int i = 1, j = 0; i < plen; i++) {
            while (j > 0 && patter.charAt(i) != patter.charAt(j)) {
                j = next[j - 1];
            }
            if (patter.charAt(i) == patter.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        for (int i = 0, j = 0; i < slen; i++) {
            if (j > 0 && patter.charAt(j) != str.charAt(i)) {
                j = next[j - 1];
            }
            if (patter.charAt(j) == str.charAt(i)) {
                j++;
            }
            // 当j==plen时，patter串已经遍历完毕，
            if (j == plen) {
                // 当i j都是下标时，i-j就是模式串在主串中出现的位置，现在j等于模式串的最大下标加一即长度，所以最后需要+1
                return i - j + 1;
            }
        }
        return -1;
    }

}
