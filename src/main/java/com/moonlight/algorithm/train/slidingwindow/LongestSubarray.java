package com.moonlight.algorithm.train.slidingwindow;

import java.util.PriorityQueue;

/**
 * 原题: https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度
 * 该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 * 输入：nums = [8,2,4,7], limit = 4     输出：2
 *
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 *
 *
 * @ClassName LongestSubarray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/21 18:00
 * @Version V1.0
 **/
public class LongestSubarray {

    public static void main(String[] args) {
        int[] nums = {8, 2, 4, 7};
        System.out.println(longestSubarray(nums, 4));

        int[] arr = {10, 1, 2, 4, 7, 2};
        System.out.println(longestSubarray(arr, 5));
    }

    public static int longestSubarray(int[] nums, int limit) {
        // 窗口内最小值
        PriorityQueue<Integer> min = new PriorityQueue<>();
        // 窗口内最大值
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int res = 0;
        for (int length = nums.length, leftPtr = 0, rightPtr = 0; rightPtr < length; rightPtr++) {

            min.add(nums[rightPtr]);

            max.add(nums[rightPtr]);

            if (max.peek() - min.peek() > limit) {
                min.remove(nums[leftPtr]);
                max.remove(nums[leftPtr]);
                leftPtr++;
            } else {
                res = Math.max(res, rightPtr - leftPtr + 1);
            }
        }
        return res;
    }

}
