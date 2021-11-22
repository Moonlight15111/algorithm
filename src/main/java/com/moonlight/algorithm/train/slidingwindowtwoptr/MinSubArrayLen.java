package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]  输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 输入：target = 4, nums = [1,4,4]  输出：1
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]  输出：0
 *
 * @author Moonlight
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3}, b = {1, 4, 4}, c = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(7, a));
        System.out.println(minSubArrayLen(4, b));
        System.out.println(minSubArrayLen(11, c));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE, left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
