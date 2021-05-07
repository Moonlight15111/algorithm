package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/reverse-string-ii/
 *
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *   1. 如果剩余字符少于 k 个，则将剩余字符全部反转。
 *   2. 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 输入: s = "abcdefg", k = 2   输出: "bacdfeg"
 *
 * @author Moonlight
 * @date 2021/5/7 13:11
 */
public class ReverseStrII {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        char c;
        // 分为大小为 2 * k 的块，进行遍历
        for (int i = 0, l, r; i < chars.length; i += (2 * k)) {
            // 可能出现剩下的不足 K 个
            l = i;
            r = Math.min(i + k - 1, chars.length - 1);
            while (l < r) {
                c = chars[l];
                chars[l++] = chars[r];
                chars[r--] = c;
            }
        }
        
        return String.valueOf(chars);
    }

}