package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/smallest-range-i/
 *
 * 给你一个整数数组 nums，请你给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k）
 * 从而得到一个新数组 result 。返回数组 result 的最大值和最小值之间可能存在的最小差值。
 *
 * 输入：nums = [1], k = 0  输出：0
 * 解释：result = [1]
 *
 * 输入：nums = [0,10], k = 2  输出：6
 * 解释：result = [2,8]
 *
 * 输入：nums = [1,3,6], k = 3  输出：0
 * 解释：result = [3,3,3] or result = [4,4,4]
 *
 * @author Moonlight
 * @date 2021/7/20 16:18
 */
public class SmallestRangeI {

    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{1}, 0));
        System.out.println(smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallestRangeI(new int[]{1, 3, 6}, 3));
    }

    public static int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        return Math.max(0, max - min - 2 * k);
    }

}
