package com.moonlight.algorithm.train.dp;

/**
 * https://leetcode-cn.com/problems/number-of-digit-one/
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 输入：n = 13  输出：6
 *
 * 输入：n = 0   输出：0
 *
 * @ClassName CountDigitOne
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/20 11:16
 * @Version V1.0
 **/
public class CountDigitOne {

    public static void main(String[] args) {
        System.out.println(violence(13) + ", " + dp(13) + ", ");
        System.out.println(violence(0) + ", " + dp(0) + ", ");
        System.out.println(violence(824883294) + ", " + dp(824883294) + ", ");
    }

    public static int batch(int n) {
        // 不能一个一个找，只能一批一批的找
        // 按照个位、十位、百位...这样子去推
        int ans = 0, i = 1;

        return ans;
    }

    public static int dp(int n) {
        // oom
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i % 10] + dp[i / 10];
            ans += dp[i];
        }
        return ans;
    }

    public static int violence(int n) {
        // timeout
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0, num = i;
            while (num != 0) {
                if (num % 10 == 1) {
                    cnt++;
                }
                num /= 10;
            }
            ans += cnt;
        }
        return ans;
    }

}