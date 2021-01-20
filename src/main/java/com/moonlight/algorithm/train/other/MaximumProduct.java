package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 输入: [1,2,3,4]  输出: 24
 * @author Moonlight
 * @date 2021/1/20 11:29
 */
public class MaximumProduct {

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-100, -98, -1, 2, 3, 4}));
        System.out.println(maximumProduct(new int[]{2, 4, 1, 2, 4}));
    }

    public static int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                nums[0] * nums[1] * nums[nums.length - 1]);
    }

}
