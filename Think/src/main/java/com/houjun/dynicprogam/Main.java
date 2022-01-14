package com.houjun.dynicprogam;


import java.util.Arrays;

/**
 * @author HouJun
 * @date 2021-12-22 11:27
 */
public class Main {
    public static void main(String[] args) {
        long d[]=new long[3];

        d[0]=1;d[1]=1;

        for(int i=2;i<100;i++)
        {
            d[i%3]=d[(i-1)%3]+d[(i-2)%3];
        }
        char[] chars = "abc".toCharArray();
        System.out.println(new String(chars));
        System.out.printf("%d",d[99%3]);
        Arrays.sort(chars);
    }
}
