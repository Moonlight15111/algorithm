package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/house-robber-ii/
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * @author Moonlight
 * @date 2021/1/13 14:17
 */
public class HouseRobberii {

    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        int[] arr22 = {1, 2, 3, 1};
        System.out.println(rob(arr));
        System.out.println(rob(arr22));

        System.out.println(rob222(arr));
        System.out.println(rob222(arr22));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(process(nums, 1, nums.length), process(nums, 0, nums.length - 1));
    }

    private static int process(int[] nums, int index, int limit) {
        if (index >= limit) {
            return 0;
        }
        return Math.max(nums[index] + process(nums, index + 2, limit), process(nums, index + 1, limit));
    }

    public static int rob222(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] first = new int[nums.length];
        Arrays.fill(first, -1);
        int[] last = new int[nums.length];
        Arrays.fill(last, -1);
        return Math.max(process222(nums, 1, nums.length, last), process222(nums, 0, nums.length - 1, first));
    }

    private static int process222(int[] nums, int index, int limit, int[] dp) {
        if (index >= limit) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        dp[index] = Math.max(nums[index] + process222(nums, index + 2, limit, dp), process222(nums, index + 1, limit, dp));
        return dp[index];
    }

}
