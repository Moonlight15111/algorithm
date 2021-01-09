package com.moonlight.algorithm.train.dp;

/**
 * 两个字符串的最长公共子序列
 * @ClassName LongestPublicSubSequence
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/9 17:40
 * @Version V1.0
 **/
public class LongestPublicSubSequence {

    public static int longestPublicSubSequence(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        int[][] dp = new int[aLen][bLen];

        dp[0][0] = a.charAt(0) == b.charAt(0) ? 1 : 0;
        for (int i = 1; i < bLen; i++) {
            dp[0][i] = a.charAt(0) == b.charAt(i) ? 1 : 0;
        }
        for (int i = 1; i < aLen; i++) {
            dp[i][0] = a.charAt(i) == b.charAt(0) ? 1 : 0;
        }

        for (int i = 1; i < aLen; i++) {
            for (int j = 1; j < bLen; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        return dp[aLen - 1][bLen - 1];
    }

}
