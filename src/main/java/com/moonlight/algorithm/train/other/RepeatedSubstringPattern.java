package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/repeated-substring-pattern/
 *
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 输入: "abab"  输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 *
 * 输入: "aba"  输出: False
 *
 * 输入: "abcabcabcabc"  输出: True
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 *
 * @author Moonlight
 * @date 2021/4/15 12:45
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, (s.length() << 1) - 1).contains(s);
    }

}
