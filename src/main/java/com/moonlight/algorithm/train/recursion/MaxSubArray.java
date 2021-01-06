package com.moonlight.algorithm.train.recursion;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-subarray/
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author Moonlight
 * @date 2021/1/6 11:20
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArray222(arr));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 第 i 个数是单独取一个还是取整段，这取决于从 0 到 i 的和 与 i 之间谁大
        int max = 0, res = nums[0];
        for (int num : nums) {
            max = Math.max(max + num, num);
            res = Math.max(res, max);
        }
        return res;
    }

    public static int maxSubArray222(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1, length = nums.length; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }


}