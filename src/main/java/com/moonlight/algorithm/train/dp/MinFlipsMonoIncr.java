package com.moonlight.algorithm.train.dp;

/**
 * https://leetcode-cn.com/problems/flip-string-to-monotone-increasing/
 *
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * 返回使 s 单调递增的最小翻转次数。
 *
 * 输入：s = "00110"  输出：1
 * 解释：翻转最后一位得到 00111.
 *
 * 输入：s = "010110"  输出：2
 * 解释：翻转得到 011111，或者是 000111。
 *
 * 输入：s = "00011000"  输出：2
 * 解释：翻转得到 00000000。
 *
 * @author Moonlight
 * @date 2022-04-28 14:28
 */
public class MinFlipsMonoIncr {

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }

    public static int minFlipsMonoIncr(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        // 每个字符只有 转为0 或者 转为 1 两种情况
        // 使用 二维数组的第一行存储 字符转为0 的操作次数, 第二行存储 字符转为1 的操作次数
        // 对于转为0的情况:
        //     1. 如果当前字符i是0，则表示不用转，即当前字符的操作次数和 dp[0][i - 1] 一致
        //     2. 如果当前字符i是1，则表示需要转，即当前字符的操作次数为 dp[0][i - 1] + 1
        // 对于转为1的情况:
        //     因为题目要求求最小次数，且上面已经统计过转为0的情况了，所以在统计转为1的情况时，我们需要考虑到转为0的操作次数
        //     1. 如果当前字符i是1，则表示不用转，即当前字符的操作次数为 min(dp[0][i - 1], dp[1][i - 1])
        //     2. 如果当前字符i是0，则表示需要转，即当前字符操作次数为 min(dp[0][i - 1], dp[1][i - 1]) + 1
        int[][] dp = new int[2][s.length()];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1][0] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int zero = dp[0][i - 1];
            int one = dp[1][i - 1];

            dp[0][i] = s.charAt(i) == '0' ? zero : zero + 1;
            dp[1][i] = Math.min(zero, one) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[0][s.length() - 1], dp[1][s.length() - 1]);
    }

}
