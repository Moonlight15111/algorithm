package com.moonlight.algorithm.train.string;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 输入: "A man, a plan, a canal: Panama"   输出: true
 *
 * 输入: "race a car"    输出: false
 *
 * @ClassName ValidPalindrome
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/27 16:37
 * @Version V1.0
 **/
public class ValidPalindrome {


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));

        System.out.println(isPalindrome12312("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome12312("race a car"));
    }

    public static boolean isPalindrome12312(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        s = builder.toString();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }
        String string = new StringBuilder(builder).reverse().toString();
        return string.equals(builder.toString());
    }

}
