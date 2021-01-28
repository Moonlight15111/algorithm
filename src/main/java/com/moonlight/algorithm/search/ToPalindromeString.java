package com.moonlight.algorithm.search;

/**
 * 给定一个字符串S,只能在S后面添加字符的情况下，求使S变为回文字符串的最少字符串是什么
 * @ClassName ToPalindromeString
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/28 20:38
 * @Version V1.0
 **/
public class ToPalindromeString {

    public static void main (String[] args) {
        System.out.println(addShortEnd("abcd123321"));
    }

    public static String addShortEnd(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        String s1 = sb.append("#").toString();

        int[] pArr = new int[s1.length()];
        int cert = 0, longestRight = 0;
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            pArr[i] = longestRight > i ? Math.min(pArr[2 * cert - i], longestRight - i) : 1;

            while (i + pArr[i] < s1.length() && i - pArr[i] > -1) {
                if (s1.charAt(i + pArr[i]) == s1.charAt(i - pArr[i])) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (longestRight < i + pArr[i]) {
                longestRight = i + pArr[i];
                cert = i;
            }
            if (longestRight == s1.length()) {
                max = pArr[i];
                break;
            }
        }
        char[] res = new char[s.length() - max + 1];
        for (int i = 0; i < res.length; i++) {
            res[res.length - 1 - i] = s1.charAt(2 * i + 1);
        }
        return String.valueOf(res);
    }

}
