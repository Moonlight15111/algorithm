package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * 输入：[1,2,2]  输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 输入：[3,2,1,2,1,7]  输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * @author Moonlight
 */
public class MinIncrementForUnique {

    public static void main(String[] args) {
        int[] a = {1, 2, 2}, b = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(a));
        System.out.println(minIncrementForUnique(b));
    }

    public static int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 排序之后,都使 nums[i] = nums[i - 1] + 1
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] == nums[i - 1]) {
                ans++;
                nums[i]++;
            } else if (nums[i] < nums[i - 1]) {
                ans += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

}