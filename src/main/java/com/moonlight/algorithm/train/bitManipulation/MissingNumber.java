package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/missing-number/
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * 输入：nums = [3,0,1]
 * 输出：2
 * 解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
 * @author Moonlight
 * @date 2020/12/18 10:33
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
        System.out.println(missingNumber222(arr));
        int[] arr2 = {0, 1};
        System.out.println(missingNumber(arr2));
        System.out.println(missingNumber222(arr2));
        int[] arr3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(arr3));
        System.out.println(missingNumber222(arr3));
        int[] arr4 = {0};
        System.out.println(missingNumber(arr4));
        System.out.println(missingNumber222(arr4));
    }

    public static int missingNumber222(int[] nums) {
        int length = nums.length;

        int xor = length;
        for (int i = 0; i < length; i++) {
            xor ^= i;
        }
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length;

        Arrays.sort(nums);

        if (length != nums[length - 1]) {
            return length;
        }
        if (0 != nums[0]) {
            return 0;
        }

        int target;
        for (int i = 1; i < length; i++) {
            target = nums[i - 1] + 1;
            if (nums[i] != target) {
                return target;
            }
        }
        return Integer.MIN_VALUE;
    }

}
