package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 输入: "abccccdd"  输出: 7
 * 解释:我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @ClassName LongestPalindrome
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/17 14:25
 * @Version V1.0
 **/
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }

    public static int longestPalindrome(String s) {
        int[] help = new int[58];
        for (char c : s.toCharArray()) {
            help[c - 'A']++;
        }
        int res = 0;
        boolean flag = false;
        for (int n : help) {
            if (n == 0) {
                continue;
            }
            if ((n & 1) == 0) {
                res += n;
            } else {
                res += n - 1;
                flag = true;
            }
        }
        return flag ? res + 1 : res;
    }

}
