package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 *
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 * 输入：steps = 3, arrLen = 2    输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 *       向右，向左，不动
 *       不动，向右，向左
 *       向右，不动，向左
 *       不动，不动，不动
 *
 * 输入：steps = 2, arrLen = 4    输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 *       向右，向左
 *       不动，不动
 *
 * 输入：steps = 4, arrLen = 2    输出：8
 *
 * @author Moonlight
 * @date 2021/5/13 13:05
 */
public class NumWays {

    public static void main(String[] args) {
        System.out.println(recursion(3, 2) + ", " + memory(3, 2));
        System.out.println(recursion(2, 4) + ", " + memory(2, 4));
        System.out.println(recursion(4, 2) + ", " + memory(4, 2));
        System.out.println(memory(27, 7));
    }

    public static int dp(int steps, int arrLen) {
        // todo dp
        return 0;
    }

    public static int memory(int steps, int arrLen) {
        int[][] dp = new int[Math.min(steps, arrLen - 1) + 1][steps + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return memory(0, steps, arrLen - 1, dp);
    }

    private static int memory(int cur, int rest, int limit, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        if (rest < (cur >>> 1)) {
            dp[cur][rest] = 0;
            return dp[cur][rest];
        }
        if (rest == 0) {
            dp[cur][rest] = cur == 0 ? 1 : 0;
            return dp[cur][rest];
        }
        long ans = 0;
        if (cur != 0) {
            ans += memory(cur - 1, rest - 1, limit, dp);
        }
        if (cur != limit) {
            ans += memory(cur + 1, rest - 1, limit, dp);
        }
        ans += memory(cur, rest - 1, limit, dp);

        dp[cur][rest] = (int)(ans % 1000000007);

        return dp[cur][rest];
    }

    public static int recursion(int steps, int arrLen) {
        return recursion(0, steps, arrLen - 1);
    }

    private static int recursion(int cur, int rest, int limit) {
        if (rest == 0) {
            return cur == 0 ? 1 : 0;
        }
        int ans = 0;
        if (cur != 0) {
            ans += recursion(cur - 1, rest - 1, limit) % 1000000007;
        }
        if (cur != limit) {
            ans += recursion(cur + 1, rest - 1, limit) % 1000000007;
        }
        ans += recursion(cur, rest - 1, limit) % 1000000007;
        return ans;
    }

}
