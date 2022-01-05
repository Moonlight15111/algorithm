package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/removing-minimum-and-maximum-from-array/
 *
 * 给你一个下标从 0 开始的数组 nums ，数组由若干 互不相同 的整数组成。
 * nums 中有一个值最小的元素和一个值最大的元素。分别称为 最小值 和 最大值 。你的目标是从数组中移除这两个元素。
 * 一次 删除 操作定义为从数组的 前面 移除一个元素或从数组的 后面 移除一个元素。
 * 返回将数组中最小值和最大值 都 移除需要的最小删除次数。
 *
 * 输入：nums = [2,10,7,5,4,1,8,6]  输出：5
 *
 * 输入：nums = [0,-4,19,1,8,-2,-3,5]  输出：3
 *
 * 输入：nums = [101]  输出：1
 *
 * @author Moonlight
 */
public class MinimumDeletions {

    public static void main(String[] args) {
        int[] a = {2, 10, 7, 5, 4, 1, 8, 6},
              b = {0, -4, 19, 1, 8, -2, -3, 5},
              c = {101};
        System.out.println(minimumDeletions(a));
        System.out.println(minimumDeletions(b));
        System.out.println(minimumDeletions(c));
    }

    public static int minimumDeletions(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int len = nums.length, min = 0, max = 0, ans;
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[min]) {
                min = i;
            }
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        if (max < min) {
            int t = min;
            min = max;
            max = t;
        }
        ans = Math.min(max + 1, len - min);
        return Math.min(ans, min + 1 + len - max);
    }

}