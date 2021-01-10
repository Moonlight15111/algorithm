package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 原题：https://leetcode-cn.com/problems/the-masseuse-lcci/
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * @ClassName Massage
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/10 12:34
 * @Version V1.0
 **/
public class Massage {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {2, 7, 9, 3, 1};
        int[] c = {2, 1, 4, 5, 3, 1, 1, 3};

        System.out.println(massage(a));
        System.out.println(massage(b));
        System.out.println(massage(c));

        System.out.println(massage222(a));
        System.out.println(massage222(b));
        System.out.println(massage222(c));

        System.out.println(dp(a));
        System.out.println(dp(b));
        System.out.println(dp(c));
    }

    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0);
    }

    private static int process(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int count = 0;
        count += Math.max(process(nums, index + 1), nums[index] + process(nums, index + 2));
        return count;
    }

    public static int massage222(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return process222(nums, 0, dp);
    }

    private static int process222(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int count = 0;
        count += Math.max(process222(nums, index + 1, dp), nums[index] + process222(nums, index + 2, dp));
        dp[index] = count;
        return dp[index];
    }

    public static int dp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[nums.length] = 0;
        for (int index = nums.length - 1; index >= 0; index--) {
            dp[index] = Math.max(dp[index + 1], index + 2 >= dp.length ? nums[index] : nums[index] + dp[index + 2]);
        }
        return dp[0];
    }
}
