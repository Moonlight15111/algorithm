package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 *
 * 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
 * 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
 *
 * 输入: "aba", "cdc"  输出: 3
 * 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
 *
 * 输入：a = "aaa", b = "bbb"  输出：3
 *
 * 输入：a = "aaa", b = "aaa" 输出：-1
 *
 * 1. 两个字符串长度均处于区间 [1 - 100] 。2. 字符串中的字符仅含有 'a'~'z' 。
 *
 * @author Moonlight
 * @date 2021/5/6 13:40
 */
public class FindLUSlength {

    public static void main(String[] args) {
        System.out.println(findLUSlength("aba", "cdc"));
        System.out.println(findLUSlength("aaa", "bbb"));
        System.out.println(findLUSlength("aaa", "aaa"));
    }

    public static int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }

}
