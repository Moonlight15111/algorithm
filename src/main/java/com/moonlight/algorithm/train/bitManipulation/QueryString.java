package com.moonlight.algorithm.train.bitManipulation;

/**
 * https://leetcode.cn/problems/binary-string-with-substrings-representing-1-to-n/
 *
 * 给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数
 * 其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 false 。
 * 子字符串 是字符串中连续的字符序列
 *
 * 1 <= s.length <= 1000
 * s[i] 不是 '0' 就是 '1'
 * 1 <= n <= 10^9
 *
 * 输入：s = "0110", n = 3  输出：true
 *
 * 输入：s = "0110", n = 4  输出：false
 *
 * @author Moonlight
 */
public class QueryString {

    public static void main(String[] args) {
        System.out.println(queryString("0110", 3));
        System.out.println(queryString("0110", 4));
    }

    public static boolean queryString(String s, int n) {
        for (int i = 1; i <= n ; i++) {
            if (!s.contains(getBinaryStr(i))) {
                return false;
            }
        }
        return true;
    }

    private static CharSequence getBinaryStr(int i) {
        StringBuilder res = new StringBuilder();
        while (i > 0) {
            res.append((i & 1) == 0 ? '0' : '1');
            i >>= 1;
        }
        return res.reverse().toString();
    }

}