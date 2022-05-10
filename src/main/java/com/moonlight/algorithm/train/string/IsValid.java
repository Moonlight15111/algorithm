package com.moonlight.algorithm.train.string;

/**
 * https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/
 *
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 *    将字符串 "abc" 插入到 t 中的任意位置。
 *    形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 *
 * 1 <= s.length <= 2 * 10^4  s 由字母 'a'、'b' 和 'c' 组成
 *
 * 输入：s = "aabcbc"  输出：true
 * 解释：
 * "" -> "abc" -> "aabcbc"
 * 因此，"aabcbc" 有效。
 *
 * 输入：s = "abcabcababcc"  输出：true
 * 解释：
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * 因此，"abcabcababcc" 有效。
 *
 * 输入：s = "abccba"  输出：false
 *
 * @author Moonlight
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("aabcbc"));
        System.out.println(isValid("abcabcababcc"));
        System.out.println(isValid("abccba"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() < 3) {
            return false;
        }
        if ("abc".equals(s)) {
            return true;
        }
        // 如果 字符串s 可以由t从 "" 反复添加 abc 而来，那么反向消解 字符串s 中的 abc 肯定也能够得到 ""
        String t = s.replaceAll("abc", "");
        while (t.length() != s.length()) {
            s = t;
            t = s.replaceAll("abc", "");
        }
        return s.length() == 0;
    }

}