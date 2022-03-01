package com.houjun.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 917. 仅仅反转字母
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * 返回反转后的 s
 */
public class Solution223 {

    public static List<Arguments> reverseOnlyLetters() {
        List<Arguments> list = new ArrayList();
        list.add(Arguments.arguments("782_]"));
        return list;
    }

    @MethodSource
    @ParameterizedTest
    public void reverseOnlyLetters(String s) {
        if (s == null) {
            return;
        }
        int len = s.length(), i = 0, j = len - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetter(chars[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(chars[j])) {
                j--;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        System.out.println(new String(chars));
    }
}
