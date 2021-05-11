package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * <p>
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 输入：nums = [100,4,200,1,3,2]   输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]  输出：9
 *
 * @author Moonlight
 * @date 2021/5/11 12:59
 */
public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2}, b = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, c = {1, 2, 0, 1};
        System.out.println(longestConsecutive(a));
        System.out.println(longestConsecutive(b));
        System.out.println(longestConsecutive(c));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int ans = 0, seq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i] - 1) {
                seq++;
            } else if (nums[i - 1] < nums[i]) {
                ans = Math.max(ans, seq);
                seq = 1;
            }
        }

        return Math.max(ans, seq);
    }

}
