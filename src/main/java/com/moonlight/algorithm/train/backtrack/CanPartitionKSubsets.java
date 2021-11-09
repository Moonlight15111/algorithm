package com.moonlight.algorithm.train.backtrack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 *
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4  输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 * @author Moonlight
 */
public class CanPartitionKSubsets {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 3, 5, 2, 1};
        System.out.println(canPartitionKSubsets(a, 4));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return backtrack(0, 0, sum / k, k, nums, visited);
    }

    private static boolean backtrack(int start, int curSum, int targetSum, int k, int[] nums, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (curSum == targetSum) {
            return backtrack(0, 0, targetSum, k - 1, nums, visited);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (backtrack(i + 1, curSum + nums[i], targetSum, k, nums, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

}
