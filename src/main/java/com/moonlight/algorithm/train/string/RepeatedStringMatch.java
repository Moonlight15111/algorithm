package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/repeated-string-match/
 *
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 *
 * 输入：a = "abcd", b = "cdabcdab"  输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 *
 * 输入：a = "a", b = "aa"  输出：2
 *
 * 输入：a = "a", b = "a"  输出：1
 *
 * 输入：a = "abc", b = "wxyz"  输出：-1
 *
 * @author Moonlight
 */
public class RepeatedStringMatch {

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
        System.out.println(repeatedStringMatch("a", "aa"));
        System.out.println(repeatedStringMatch("a", "a"));
        System.out.println(repeatedStringMatch("abc", "wxyz"));
    }

    public static int repeatedStringMatch(String a, String b) {
        int mul = b.length() / a.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= mul + 2; i++) {
            if (sb.indexOf(b) >= 0) {
                return i;
            }
            sb.append(a);
        }
        return -1;
    }

}
