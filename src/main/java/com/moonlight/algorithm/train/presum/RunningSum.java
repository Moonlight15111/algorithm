package com.moonlight.algorithm.train.presum;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 *
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 *
 * 输入：nums = [1,2,3,4]  输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 *
 * 输入：nums = [1,1,1,1,1]  输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 * 输入：nums = [3,1,2,10,1]  输出：[3,4,6,16,17]
 *
 * @author Moonlight
 */
public class RunningSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(runningSum(new int[]{3, 1, 2, 10, 1})));
    }

    public static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0, p = 0; i < nums.length; i++) {
            ans[i] = p + nums[i];
            p = ans[i];
        }
        return ans;
    }

}
