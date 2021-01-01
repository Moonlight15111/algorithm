package com.moonlight.algorithm.train.dp;

/**
 * 原题：https://leetcode-cn.com/problems/three-steps-problem-lcci/
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 * 输入：n = 3
 * 输出：4
 * 说明: 有四种走法
 *
 * @ClassName WaysToStep
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/1 19:39
 * @Version V1.0
 **/
public class WaysToStep {

    public static void main(String[] args) {
        System.out.println(waysToStep(3));
        System.out.println(waysToStep(5));

        System.out.println(waysToStep222(3));
        System.out.println(waysToStep222(5));
    }

    public static int waysToStep222(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n];
    }

    public static int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        return waysToStep(n - 1) + waysToStep(n - 2) + waysToStep(n - 3);
    }

}
