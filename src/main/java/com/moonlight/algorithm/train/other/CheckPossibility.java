package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 输入: nums = [4,2,3]   输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 输入: nums = [4,2,1]   输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * @author Moonlight
 * @date 2021/5/18 13:36
 */
public class CheckPossibility {

    public static void main(String[] args) {
        int[] a = {4, 2, 3}, b = {4, 2, 1}, c = {3, 4, 2, 3};
        System.out.println(checkPossibility(a));
        System.out.println(checkPossibility(b));
        System.out.println(checkPossibility(c));
    }

    public static boolean checkPossibility(int[] nums) {
        int cnt = 0, n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                cnt++;
                if (cnt >= 2) {
                    return false;
                }
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

}
