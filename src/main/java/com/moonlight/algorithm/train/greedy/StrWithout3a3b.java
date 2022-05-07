package com.moonlight.algorithm.train.greedy;

/**
 * https://leetcode-cn.com/problems/string-without-aaa-or-bbb/
 *
 * 给定两个整数 a 和 b ，返回 任意 字符串 s ，要求满足：
 *    s 的长度为 a + b，且正好包含a 个 'a' 字母与 b 个 'b' 字母；
 *   子串 'aaa' 没有出现在 s 中；
 *   子串 'bbb' 没有出现在 s 中。
 *
 * 输入：a = 1, b = 2  输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 *
 * 输入：a = 4, b = 1  输出："aabaa"
 *
 * @author Moonlight
 */
public class StrWithout3a3b {

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(1, 2));
        System.out.println(strWithout3a3b(4, 1));
    }

    public static String strWithout3a3b(int a, int b) {
        StringBuilder ans = new StringBuilder();
        while (a > b && b > 0) {
            ans.append("aab");
            a -= 2;
            b--;
        }
        while (b > a && a > 0) {
            ans.append("bba");
            b -= 2;
            a--;
        }
        while (a > 0 && b > 0) {
            ans.append("ab");
            a--;
            b--;
        }
        while (a > 0) {
            ans.append("a");
            a--;
        }
        while (b > 0) {
            ans.append("b");
            b--;
        }
        return ans.toString();
    }

}