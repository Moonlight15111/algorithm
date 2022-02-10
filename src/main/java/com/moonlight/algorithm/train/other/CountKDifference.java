package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * |x| 的值定义为：
 *   如果 x >= 0 ，那么值为 x 。
 *   如果 x < 0 ，那么值为 -x 。
 *
 * 输入：nums = [1,2,2,1], k = 1  输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 *
 * 输入：nums = [1,3], k = 3  输出：0
 *
 * 输入：nums = [3,2,1,5,4], k = 2  输出：3
 *
 * @author Moonlight
 */
public class CountKDifference {

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println(countKDifference(new int[]{1, 3}, 3));
        System.out.println(countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }

    public static int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            ans += cnt.getOrDefault(num - k, 0) + cnt.getOrDefault(num + k, 0);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return ans;
    }

}