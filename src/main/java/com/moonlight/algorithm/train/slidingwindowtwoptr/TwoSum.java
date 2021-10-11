package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * @ClassName TwoSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/11 21:33
 * @Version V1.0
 **/
public class TwoSum {

    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15}, b = {10, 26, 30, 31, 47, 60};
        System.out.println(Arrays.toString(twoSum(a, 9)));
        System.out.println(Arrays.toString(twoSum(b, 40)));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        int l = 0, r = nums.length - 1, s;
        while (l < r) {
            s = nums[l] + nums[r];
            if (s < target) {
                l++;
            } else if (s > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[0];
    }

}
