package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/max-number-of-k-sum-pairs/
 *
 * 给你一个整数数组 nums 和一个整数 k 。
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * 返回你可以对数组执行的最大操作数。
 *
 * 输入：nums = [1,2,3,4], k = 5   输出：2
 * 解释：开始时 nums = [1,2,3,4]：
 *       - 移出 1 和 4 ，之后 nums = [2,3]
 *       - 移出 2 和 3 ，之后 nums = []
 *       不再有和为 5 的数对，因此最多执行 2 次操作。
 *
 * 输入：nums = [3,1,3,4,3], k = 6  输出：1
 * 解释：开始时 nums = [3,1,3,4,3]：
 *       - 移出前两个 3 ，之后nums = [1,4,3]
 *       不再有和为 6 的数对，因此最多执行 1 次操作。
 *
 * */
public class MaxOperations {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4}, b = {3, 1, 3, 4, 3};
        System.out.println(maxOperations(a, 5));
        System.out.println(maxOperations(b, 6));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, l = 0, r = len - 1, ans = 0, s;
        while (l < r) {
            s = nums[l] + nums[r];
            if (s > k) {
                r--;
            } else if (s < k) {
                l++;
            } else {
                ans++;
                l++;
                r--;
            }
        }
        return ans;
    }

}
