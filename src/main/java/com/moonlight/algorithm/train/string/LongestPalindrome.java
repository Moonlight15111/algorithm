package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 输入：s = "babad"     输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"    输出："bb"
 *
 * @author Moonlight
 * @date 2021/1/30 14:28
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        // 直接就是一个马拉车
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append("#").append(c);
        }
        char[] str = sb.append("#").toString().toCharArray();

        int[] pArr = new int[str.length];
        int cert = 0;
        int longestRight = 0;
        int max = 0, maxCert = 0;
        for (int i = 0; i < str.length; i++) {
            pArr[i] = longestRight > i ? Math.min(pArr[2 * cert - i], longestRight - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] >= 0) {
                if (str[i + pArr[i]] == str[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > longestRight) {
                longestRight = i + pArr[i];
                cert = i;
            }
            if (pArr[i] > max) {
                max = pArr[i];
                maxCert = i;
            }
        }
        int start = maxCert - max + 1, end = maxCert + max - 1;
        StringBuilder res = new StringBuilder();

        for (int i = start; i <= end; i++) {
            if (str[i] != '#') {
                res.append(str[i]);
            }
        }
        return res.toString();
    }

}