package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 输入: "aba"   输出: True
 *
 * 输入: "abca"  输出: True
 * 解释: 你可以删除c字符。
 *
 * 提示:
 *   字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 *
 * @author Moonlight
 * @date 2021/5/24 13:27
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        // 从两边找不相等的字符，然后判断删掉之后是否为回文
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char cl = s.charAt(l), cr = s.charAt(r);
            if (cl == cr) {
                l++;
                r--;
            } else {
                return validate(s, l, r - 1) || validate(s, l + 1, r);
            }
        }
        return true;
    }

    private static boolean validate(String s, int left , int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
