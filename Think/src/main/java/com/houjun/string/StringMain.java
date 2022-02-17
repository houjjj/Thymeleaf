package com.houjun.string;

public class StringMain {
    public static void main(String[] args) {
//        System.out.println(countAndSay2(1));
//        System.out.println(countAndSay2(2));
//        System.out.println(countAndSay2(3));
//        System.out.println(countAndSay2(4));
//        System.out.println(countAndSay2(5));

        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String countAndSay(int n) {
        // n=1 的结果
        String result = "1";
        // 第一次的结果“1” 已经是默认值，之后的计算次数n-1
        for (int i = 1; i < n; i++) {
            // 每一轮循环的临时结果
            StringBuilder sb = new StringBuilder();
            // 双指针，[start，end]范围内的元素是同一个，当end下标的元素不等于start下标时，统计start-——end有几个x，然后start=end开始判断下个x有几个
            int start = 0, end = 0;
            while (end < result.length()) {
                while (end < result.length() && result.charAt(start) == result.charAt(end)) {
                    end++;
                }
                sb.append(end - start).append(result.charAt(start));
                start = end;
            }
            result = sb.toString();
        }
        return result;
    }

    /**
     * 递归算法
     *
     * @param n
     * @return
     */
    public static String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
        String temp = countAndSay2(n - 1);
        String result = "";
        int start = 0, end = 0;
        while (end < temp.length()) {
            while (end < temp.length() && temp.charAt(start) == temp.charAt(end)) {
                end++;
            }
            result += (end - start + "") + (temp.charAt(start));
            start = end;
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        int min = strs[0].length();
        for (String s : strs) {
            if (s.length() < min) {
                min = s.length();
            }
        }
        String result = "";
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) {
                    return result;
                }
            }
            result += c + "";
        }
        return result;
    }

//    public String longestCommonPrefix12(String[] strs) {
//        if(strs.length==0) return "";
//        String s =strs[0];
//        for(String string : strs){
//            while(!string.startsWith(s)){
//                if(s.length()==0) return "";
//                s = s.substring(0,s.length()-1);
//            }
//        }
//    }
}
