package com.moonlight.algorithm.train.search;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 0  输出：true
 *
 * 输入：nums = [2,5,6,0,0,1,2], target = 3  输出：false
 *
 * @author Moonlight
 * @date 2021/4/7 13:26
 */
public class SearchInRotatedSortedArrayII {

    public static void main(String[] args) {
        int[] a = {2, 5, 6, 0, 0, 1, 2}, b = {1};
        System.out.println(search(a, 0));
        System.out.println(search(a, 3));
        System.out.println(search(b, 1));
    }

    public static boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

}
