package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 进阶：
 *    尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *    你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * @author Moonlight
 * @date 2021/4/6 13:04
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7}, b = {-1, -100, 3, 99};
//        rotate(a, 3);
//        rotate(b, 2);
        rotate123(a, 3);
        rotate123(b, 2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void rotate123(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void rotate(int[] nums, int k) {
        int[] help = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            help[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(help, 0, nums, 0, nums.length);
    }

}
