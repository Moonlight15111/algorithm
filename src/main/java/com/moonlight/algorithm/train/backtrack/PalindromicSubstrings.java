package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * <p>
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 输入："abc"  输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * <p>
 * 输入："aaa"  输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 * @author Moonlight
 * @date 2021/5/11 13:17
 */
public class PalindromicSubstrings {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int manacher(String s) {
        // todo manacher
        return 0;
    }

    public static int dp(String s) {
        // todo dp
        return 0;
    }

    public static int backtrack(String s) {
        // todo backtrack
        return 0;
    }

    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length(), ans = n;
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int left = i - 1, right = i + 1;
            while (left >= 0 && right < n && chars[left--] == chars[right++]) {
                ans++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && chars[left--] == chars[right++]) {
                ans++;
            }
        }
        return ans;
    }

}
