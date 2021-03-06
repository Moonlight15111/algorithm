package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 *
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 *
 * 输入：nums = [1,1,2,1,1], k = 3   输出：2   解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 *
 * 输入：nums = [2,4,6], k = 1       输出：0   解释：数列中不包含任何奇数，所以不存在优美子数组。
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2   输出：16
 *
 * @author Moonlight
 * @date 2021/3/6 12:00
 */
public class CountNumberOfNiceSubarrays {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 1}, b = {2, 4, 6}, c = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays(a, 3));
        System.out.println(numberOfSubarrays(b, 1));
        System.out.println(numberOfSubarrays(c, 2));
    }

    public static int numberOfSubarraysTwoPtr(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        // todo 其实和数组中偶数没有关系了，只需要在意奇数的个数就好
        return 0;
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        // 超时
        if (nums == null || nums.length < k) {
            return 0;
        }
        int len = nums.length, res = 0, odd = 0;

        for (int i = 0; i <= len; i++) {
            odd = 0;
            for (int j = i; j < len; j++) {
                if ((nums[j] & 1) == 1) {
                    odd++;
                }
                if (odd == k) {
                    res++;
                }
            }
        }
        return res;
    }

}
