package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/RQku0D/
 *
 * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 * 输入: s = "aba"  输出: true
 *
 * 输入: s = "abca"  输出: true
 * 解释: 可以删除 "c" 字符 或者 "b" 字符
 *
 * 输入: s = "abc"  输出: false
 *
 * @ClassName ValidPalindrome
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/17 12:23
 * @Version V1.0
 **/
public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return valid(s, l, r - 1) || valid(s, l + 1, r);
            }
        }
        return true;
    }

    private static boolean valid(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
