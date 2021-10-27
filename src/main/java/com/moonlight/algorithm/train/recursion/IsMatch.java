package com.moonlight.algorithm.train.recursion;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *    '.' 匹配任意单个字符
 *    '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 输入：s = "aa" p = "a"  输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 *
 * 输入：s = "aa" p = "a*"  输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 输入：s = "ab" p = ".*"  输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 输入：s = "aab" p = "c*a*b"  输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 输入：s = "mississippi" p = "mis*is*p*."  输出：false
 *
 * @author Moonlight
 */
public class IsMatch {

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 第一个字符是否匹配
        boolean match = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 后续字符是否匹配
        // 后续字符有两种匹配方式: 1. 不管p的前两个字符，直接匹配后面的，因为 * 是匹配零个或多个前面的那一个元素
        //                       2. 第一个字符已经匹配了，那么就可以从第二个字符开始往后面继续尝试
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (match && isMatch(s.substring(1), p));
        }
        // 第一个字符已经匹配了, 从第二个字符开始往后面继续尝试
        return match && isMatch(s.substring(1), p.substring(1));
    }

}