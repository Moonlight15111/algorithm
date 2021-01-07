package com.moonlight.algorithm.train.dp;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/is-subsequence/
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例
 * 如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 输入：s = "abc", t = "ahbgdc"  输出：true
 *
 * 输入：s = "axc", t = "ahbgdc"  输出：false
 *
 * @author Moonlight
 * @date 2021/1/7 14:56
 */
public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("c", "b"));

        System.out.println(isSubsequence1212("abc", "ahbgdc"));
        System.out.println(isSubsequence1212("c", "b"));
    }

    public static boolean isSubsequence(String s, String t) {
        int slen = s.length(), tLen = t.length();
        int sPointer = 0, tPointer = 0;
        while (sPointer < slen && tPointer < tLen) {
            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
            }
            tPointer++;
        }
        return sPointer == slen;
    }

    public static boolean isSubsequence1212(String s, String t) {
        return getAllSubsequence(t).contains(s);
    }

    public static List<String> getAllSubsequence(String string) {
        List<String> res = new ArrayList<>();
        if (string == null) {
            return res;
        }
        if (string.length() == 0) {
            res.add("");
            return res;
        }
        String path = "";
        process(string.toCharArray(), 0, path, res);
        return res;
    }

    private static void process(char[] chars, int index, String path, List<String> res) {
        if (index == chars.length) {
            res.add(path);
            return;
        }
        process(chars, index + 1, path, res);
        String tmp = path + chars[index];
        process(chars, index + 1, tmp, res);
    }

}
