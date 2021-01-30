package com.moonlight.algorithm.train.search;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8    输出：[3,4]
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6    输出：[-1,-1]
 *
 * @author Moonlight
 * @date 2021/1/30 15:38
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(arr, 8)));

        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 找第一个等于target的位置 和 第一个大于target的位置
        int firstPos = findPosition(nums, target, true);
        int secondPos = findPosition(nums, target, false) - 1;
        if (firstPos <= secondPos && secondPos < nums.length && nums[firstPos] == target && nums[firstPos] == nums[secondPos]) {
            return new int[]{firstPos, secondPos};
        }
        return new int[]{-1, -1};
    }

    private static int findPosition(int[] nums, int target, boolean searchFirst) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int res = nums.length;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target || (searchFirst && nums[mid] >= target)) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
