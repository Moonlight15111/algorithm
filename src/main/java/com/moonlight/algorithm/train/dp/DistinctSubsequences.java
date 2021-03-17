package com.moonlight.algorithm.train.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/distinct-subsequences/
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 输入：s = "rabbbit", t = "rabbit"    输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * 输入：s = "babgbag", t = "bag"   输出：5
 *
 * @author Moonlight
 * @date 2021/3/17 9:29
 */
public class DistinctSubsequences {

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit") + ", "
                + numDistinct1231("rabbbit", "rabbit") + ", "
                + numDistinct1231213("rabbbit", "rabbit") + ", "
                + numDistinctDP("rabbbit", "rabbit"));

        System.out.println(numDistinct("babgbag", "bag") + ", "
                + numDistinct1231("babgbag", "bag") + ", "
                + numDistinct1231213("babgbag", "bag") + ", "
                + numDistinctDP("babgbag", "bag"));
    }

    public static int numDistinctDP(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }

        int sLen = s.length(), tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][tLen] = 1;
        }
        for (int i = sLen - 1; i >= 0; i--) {
            for (int j = tLen - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static int numDistinct1231213(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] dd : dp) {
            Arrays.fill(dd, -1);
        }
        return memorySearch(0, 0, s, t, dp);
    }

    private static int memorySearch(int sIndex, int tIndex, String s, String t, int[][] dp) {
        if (dp[sIndex][tIndex] != -1) {
            return dp[sIndex][tIndex];
        }
        if (t.length() - tIndex > s.length() - sIndex) {
            dp[sIndex][tIndex] = 0;
            return dp[sIndex][tIndex];
        }
        if (tIndex >= t.length()) {
            dp[sIndex][tIndex] = 1;
            return dp[sIndex][tIndex];
        }
        dp[sIndex][tIndex] = s.charAt(sIndex) == t.charAt(tIndex)
                ? memorySearch(sIndex + 1, tIndex + 1, s, t, dp) + memorySearch(sIndex + 1, tIndex, s, t, dp)
                : memorySearch(sIndex + 1, tIndex, s, t, dp);
        return dp[sIndex][tIndex];
    }

    public static int numDistinct1231(String s, String t) {
        // time out
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        return recursion(0, 0, s, t);
    }

    private static int recursion(int sIndex, int tIndex, String s, String t) {
        // 一个字符一个字符的比较
        // 剪枝：当t.length() > s.length()时必定是不存在结果的
        if (t.length() - tIndex > s.length() - sIndex) {
            return 0;
        }
        // 能走到最后说明可行
        if (tIndex >= t.length()) {
            return 1;
        }
        return s.charAt(sIndex) == t.charAt(tIndex)
                // 如果匹配则有两种选择：一、双方都进行下一个字符的对比；二、那s的下一个字符和t的当前字符对比
                ? recursion(sIndex + 1, tIndex + 1, s, t) + recursion(sIndex + 1, tIndex, s, t)
                // 不匹配就只能继续拿s的下一个字符进行匹配了
                : recursion(sIndex + 1, tIndex, s, t);
    }


    public static int numDistinct(String s, String t) {
        // time out
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        List<String> res = new ArrayList<>();
        backtrack(0, new StringBuilder(), s, t, res);
        return res.size();
    }

    private static void backtrack(int index, StringBuilder builder, String s, String t, List<String> res) {
        if (builder.length() == t.length() && builder.toString().equals(t)) {
            res.add(builder.toString());
            return;
        }
        for (int i = index, len = s.length(); i < len; i++) {
            builder.append(s.charAt(i));
            backtrack(i + 1, builder, s, t, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

}
