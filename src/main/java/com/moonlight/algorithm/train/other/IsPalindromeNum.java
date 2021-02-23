package com.moonlight.algorithm.train.other;

/**
 * 原题：https://leetcode-cn.com/problems/palindrome-number/
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 输入：x = 121     输出：true
 *
 * 输入：x = -121    输出：false    解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * @ClassName IsPalindromeNum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/23 22:39
 * @Version V1.0
 **/
public class IsPalindromeNum {

    public static void main(String[] args) {
        System.out.println(isPalindrome(123321));
    }

    public static boolean isPalindrome123(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        // 只反转一半数字
        int palindrome = 0;

        while (x > palindrome) {
            palindrome = palindrome * 10 + x % 10;
            x /= 10;
        }

        // 数字长度为奇数时,因为在中位的数字不影响回文，所以我们可以直接将其抹掉
        return x == palindrome || x == palindrome / 10;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        // 直接反转X，判断是否相等  可能会溢出

        int palindrome = 0, tmp = x;

        while (tmp != 0) {
            int a = tmp % 10;
            palindrome = palindrome * 10 + a;
            tmp /= 10;
        }

        return palindrome == x;
    }

}
