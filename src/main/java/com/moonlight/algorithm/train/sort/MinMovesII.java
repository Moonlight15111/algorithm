package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
 * 其中每次移动可将选定的一个元素加1或减1。
 * 您可以假设数组的长度最多为10000。
 *
 * 输入: [1,2,3]   输出: 2
 * 说明：只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 *       [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 *
 * @author Moonlight
 * @date 2021/4/19 13:24
 */
public class MinMovesII {

    public static void main(String[] args) {
        int[] a = {1, 2, 3}, b = {1, 2, 3, 7, 8, 9};
        System.out.println(minMoves2(a));
        System.out.println(minMoves2(b));
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length, mid = n >> 1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (mid > i) {
                ans += nums[mid] - nums[i];
            } else if (mid < i) {
                ans += nums[i] - nums[mid];
            }
        }
        return ans;
    }

}
