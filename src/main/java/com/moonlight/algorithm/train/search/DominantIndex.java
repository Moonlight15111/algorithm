package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 *
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。
 * 如果是，则返回 最大元素的下标 ，否则返回 -1 。
 *
 * 输入：nums = [3,6,1,0]  输出：1
 *
 * 输入：nums = [1,2,3,4]  输出：-1
 *
 * 输入：nums = [1]  输出：0
 *
 */
public class DominantIndex {

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}));
        System.out.println(dominantIndex(new int[]{1}));
        System.out.println(dominantIndex(new int[]{1, 0}));
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int first = -1, second = -1, ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                ans = i;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return 2 * second <= first ? ans : -1;
    }

}
