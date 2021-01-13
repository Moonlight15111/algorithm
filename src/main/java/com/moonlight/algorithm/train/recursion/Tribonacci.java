package com.moonlight.algorithm.train.recursion;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * 输入：n = 4    输出：4
 * 解释：T_3 = 0 + 1 + 1 = 2    T_4 = 1 + 1 + 2 = 4
 *
 * @author Moonlight
 * @date 2021/1/13 16:08
 */
public class Tribonacci {

    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(25));

        System.out.println(tribonacci(4, new int[5]));
        System.out.println(tribonacci(25, new int[26]));

        System.out.println(t(4));
        System.out.println(t(25));
    }

    public static int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static int tribonacci(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return n;
        }
        if (n == 2) {
            dp[n] = 1;
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        dp[n] = tribonacci(n - 1, dp) + tribonacci(n - 2, dp) + tribonacci(n - 3, dp);
        return dp[n];
    }

    public static int t(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int x = 0, y = 1, z = 1, tmp;
        for (int i = 3; i <= n ; i++) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }

}