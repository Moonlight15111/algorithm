package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
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
