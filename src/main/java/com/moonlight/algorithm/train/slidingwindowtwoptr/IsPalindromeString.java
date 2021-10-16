package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/XltzEq/
 *
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 *
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *
 * @ClassName IsPalindromeString
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/16 14:16
 * @Version V1.0
 **/
public class IsPalindromeString {

    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama", b = "race a car";
        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
    }

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        int l = 0, r = sb.length() - 1;
        while (l <= r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
