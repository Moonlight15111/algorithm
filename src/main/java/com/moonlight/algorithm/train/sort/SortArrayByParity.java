package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 输入：[3,1,2,4]    输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * @author Moonlight
 * @date 2021/6/7 13:16
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int[] a = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(a)));
    }

    public static int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0, left = 0, right = nums.length - 1; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                ans[right--] = nums[i];
            } else {
                ans[left++] = nums[i];
            }
        }

        return ans;
    }

}