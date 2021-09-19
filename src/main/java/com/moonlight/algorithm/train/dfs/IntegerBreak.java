package com.moonlight.algorithm.train.dfs;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/integer-break/
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 输入: 2  输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 输入: 10 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 *
 * @ClassName IntegerBreak
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/19 12:36
 * @Version V1.0
 **/
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(timeout(2) + ", " + integerBreak(2) + ", " + dp(2));
        System.out.println(timeout(10) + ", " + integerBreak(10) + ", " + dp(10));
    }

    public static int dp(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
//        将 i 拆分成 j 和 i-j 的和，且 i-j 不再拆分成多个正整数，此时的乘积是 j * (i-j)
//        将 i 拆分成 j 和 i-j 的和，且 i-j 继续拆分成多个正整数，此时的乘积是 j * dp[i-j]
        for (int i = 2; i <= n; i++) {
            int m = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                m = Math.max(m, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = m;
        }
        return dp[n];
    }

    public static int integerBreak(int n) {
        int[] m = new int[n + 1];
        Arrays.fill(m, Integer.MIN_VALUE);
        memo(n, m);
        return m[n];
    }

    private static int memo(int n, int[] m) {
        if (n == 2) {
            m[n] = 1;
            return 1;
        }
        if (m[n] != Integer.MIN_VALUE) {
            return m[n];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * memo(n - i, m)));
        }
        m[n] = ans;
        return ans;
    }

    public static int timeout(int n) {
        if (n == 2) {
            return 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * timeout(n - i)));
        }
        return ans;
    }

}