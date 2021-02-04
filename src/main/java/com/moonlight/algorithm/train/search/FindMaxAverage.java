package com.moonlight.algorithm.train.search;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-average-subarray-i/
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * @author Moonlight
 * @date 2021/2/4 14:53
 */
public class FindMaxAverage {

    public static double findMaxAverage(int[] nums, int k) {
        int sumK = 0;

        for (int i = 0; i < k; i++) {
            sumK += nums[i];
        }

        double res = sumK;
        for (int i = k; i < nums.length; i++) {
            sumK = sumK + nums[i] - nums[i - k];
            res = Math.max(res, sumK);
        }

        return res / k;
    }

}
