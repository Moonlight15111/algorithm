package com.moonlight.algorithm.train.contest.weeklycontest242;

/**
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。
 * 一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 *     i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 *     s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 *
 * 输入：s = "011010", minJump = 2, maxJump = 3   输出：true
 * 解释： 第一步，从下标 0 移动到下标 3 。
 *       第二步，从下标 3 移动到下标 5 。
 *
 * 输入：s = "01101110", minJump = 2, maxJump = 3  输出：false
 *
 * @ClassName CanReach
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/23 11:02
 * @Version V1.0
 **/
public class CanReach {

    public static void main(String[] args) {
        System.out.println(recursion("011010", 2, 3));
        System.out.println(recursion("01101110", 2, 3));
        System.out.println(recursion("01111111011110", 1, 9));
    }

    public static boolean recursion(String s, int minJump, int maxJump) {
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for (int i = 0, max = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (int j = Math.max(max, i + minJump); j <= Math.min(i + maxJump, s.length() - 1); j++) {
                    if (s.charAt(j) == '0') {
                        dp[j] = true;
                    }
                    max = Math.max(max, j);
                }
            }
        }
        return dp[s.length() - 1];
    }

}
