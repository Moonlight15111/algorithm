package com.moonlight.algorithm.greedy;

import com.moonlight.algorithm.Const;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 *  给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 *  输入: [100, 4, 200, 1, 3, 2]
 *  输出: 4
 *  解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *  思路：设我们已经取到了第 i 个位置，如果第 i - 1 个位置的数 + 1 等于第 i 个位置的数，那么我们就说i - 1 到 i 是连续有序的
 *        如果第 i - 1 位置的数等于第 i 位置，则多个也只计入有序序列一次，如果第 i - 1 个位置的数 + 1 大于第 i 个位置的数，
 *        那么则认为连续序列在此中断了，则需要重新计数。
 * @author Moonlight
 * @date 2020/5/16 16:53
 */
public class LongestContinuousSequence {

    public static void main (String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2, 201, 202, 203, 204};
        System.out.println(longestConsecutive(arr));
    }

    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 1, sequence = 1;
        for (int i = 1, length = nums.length; i < length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                sequence++;
            } else {
                longest = Math.max(longest, sequence);
                sequence = 1;
            }
        }
        return Math.max(longest, sequence);
    }

}
