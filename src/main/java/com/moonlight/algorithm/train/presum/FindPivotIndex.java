package com.moonlight.algorithm.train.presum;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 *
 * 输入：nums = [1, 7, 3, 6, 5, 6]   输出：3
 * 解释：中心下标是 3 。 左侧数之和 (1 + 7 + 3 = 11)，右侧数之和 (5 + 6 = 11) ，二者相等。
 *
 * 输入：nums = [1, 2, 3]  输出：-1  解释：数组中不存在满足此条件的中心下标。
 *
 * 输入：nums = [2, 1, -1]  输出：0
 * 解释：中心下标是 0 。下标 0 左侧不存在元素，视作和为 0 ；右侧数之和为 1 + (-1) = 0 ，二者相等。
 *
 * @author Moonlight
 * @date 2021/5/6 15:57
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] a = {1, 7, 3, 6, 5, 6}, b = {1, 2, 3}, c = {2, 1, -1};
        // 3
        System.out.println(pivotIndex(a));
        // -1
        System.out.println(pivotIndex(b));
        // 0
        System.out.println(pivotIndex(c));
    }

    public static int pivotIndex(int[] nums) {
        int sum = 0, left = 0;
        for (int n : nums) {
            sum += n;
        }

        for (int i = 0; i < nums.length; i++) {
            if (left == sum - left - nums[i]) {
                return i;
            }
            left += nums[i];
        }

        return -1;
    }

}
