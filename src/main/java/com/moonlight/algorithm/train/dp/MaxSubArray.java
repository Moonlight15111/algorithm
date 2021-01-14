package com.moonlight.algorithm.train.dp;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]    输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * @author Moonlight
 * @date 2021/1/14 17:24
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
        // 暴力递归 每个都加一遍 O(n平方)
        int max = Integer.MIN_VALUE, length = nums.length, sum;
        for (int i = 0; i < length; i++) {
            sum = 0;
            for (int j = i; j < length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static int maxSubArray222(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 如果当前上一个数大于0，那么相加就不会对当前数产生负面影响
        int max = Integer.MIN_VALUE, cur, prev = 0;
        for (int n : nums) {
            cur = n;
            if (prev > 0) {
                cur += prev;
            }
            if (cur > max) {
                max = cur;
            }
            prev = cur;
        }
        return max;
    }

}
