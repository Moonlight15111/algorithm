package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有
 * 相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：[1,2,3,1]    输出：4     解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入：[2,7,9,3,1]  输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * @author Moonlight
 * @date 2021/1/6 14:55
 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int[] arr22 = {2, 7, 9, 3, 1};
        System.out.println(rob(arr));
        System.out.println(rob(arr22));

        System.out.println(rob2222(arr));
        System.out.println(rob2222(arr22));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 当前位置偷还是不偷, 如果当前位置偷了, 下次就只能去index + 2 位置偷
        // 如果当前位置不偷，下次就可以去index + 1 位置偷
        return process(nums, 0);
    }

    private static int process(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        int notSkip = nums[index] + process(nums, index + 2);
        int skip = process(nums, index + 1);
        return Math.max(notSkip, skip);
    }


    public static int rob2222(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 当前位置偷还是不偷, 如果当前位置偷了, 下次就只能去index + 2 位置偷
        // 如果当前位置不偷，下次就可以去index + 1 位置偷
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return process222(nums, 0, dp);
    }

    private static int process222(int[] nums, int index, int[] dp) {
        if (index == nums.length) {
            dp[index] = 0;
            return dp[index];
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int notSkip = nums[index];
        if (index + 2 <= nums.length) {
           notSkip += process222(nums, index + 2, dp);
        }
        int skip = process222(nums, index + 1, dp);
        dp[index] = Math.max(notSkip, skip);

        return dp[index];
    }
}
