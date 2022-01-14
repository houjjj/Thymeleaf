package com.houjun.test;

class Solution {
    public static String reverseWords(String s) {
        int low = 0;
        char[] ch = s.toCharArray();
        for(int high = 0;high<ch.length;high++){
            if(ch[high]==' ' || high==ch.length-1){
                reverseWord(ch,low,high-1);
                low = high+1;
            }
        }
        return new String(ch);
    }
    private static void reverseWord(char[] s,int low,int high){
        while(low < high){
          char temp = s[low];
          s[low] = s[high];
          s[high] = temp;  
        }
    }

    public static void main(String[] args) {

    }
}