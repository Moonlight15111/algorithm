package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 *
 * 给你一个数组 nums ，每次操作你可以选择 nums 中的任意一个元素并将它改成任意值。
 * 请你返回三次操作后， nums 中最大值与最小值的差的最小值。
 *
 * 输入：nums = [5,3,2,4]  输出：0
 * 解释：将数组 [5,3,2,4] 变成 [2,2,2,2].
 * 最大值与最小值的差为 2-2 = 0 。
 *
 * 输入：nums = [1,5,0,10,14]  输出：1
 * 解释：将数组 [1,5,0,10,14] 变成 [1,1,0,1,1] 。
 * 最大值与最小值的差为 1-0 = 1 。
 *
 * 输入：nums = [6,6,0,1,1,4,6]  输出：2
 *
 * 输入：nums = [1,5,6,14,15]  输出：1
 *
 * @author Moonlight
 */
public class MinDifference {

    public static void main(String[] args) {
        int[] a = {5, 3, 2, 4}, b = {1, 5, 0, 10, 14}, c = {6, 6, 0, 1, 1, 4, 6}, d = {1, 5, 6, 14, 15};
        System.out.println(minDifference(a));
        System.out.println(minDifference(b));
        System.out.println(minDifference(c));
        System.out.println(minDifference(d));
    }

    public static int minDifference(int[] nums) {
        if (nums == null || nums.length < 5) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE, len = nums.length;
        // 还是一样的思路  len - 1 - (3 - i) => len - 4 + i
        for (int i = 0; i <= 3; i++) {
            ans = Math.min(ans, nums[len - 4 + i] - nums[i]);
        }
//        // 删除三个最小值
//        if (nums[len - 1] - nums[3] < ans) {
//            ans = nums[len - 1] - nums[3];
//        }
//        // 删除两个最小值,一个最大值
//        if (nums[len - 2] - nums[2] < ans) {
//            ans = nums[len - 2] - nums[2];
//        }
//        // 删除一个最小值，两个最大值
//        if (nums[len - 3] - nums[1] < ans) {
//            ans = nums[len - 3] - nums[1];
//        }
//        // 删除三个最大值
//        if (nums[len - 4] - nums[0] < ans) {
//            ans = nums[len - 4] - nums[0];
//        }
        return ans;
    }

}
