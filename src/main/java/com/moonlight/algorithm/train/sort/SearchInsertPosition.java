package com.moonlight.algorithm.train.sort;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 输入: [1,3,5,6], 5  输出: 2
 *
 * 输入: [1,3,5,6], 2  输出: 1
 *
 * 输入: [1,3,5,6], 7  输出: 4
 *
 * 输入: [1,3,5,6], 0  输出: 0
 *
 * @author Moonlight
 * @date 2021/3/22 9:12
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6}, b = {1};
        System.out.println(searchInsert(a, 5));
        System.out.println(searchInsert(a, 2));
        System.out.println(searchInsert(a, 7));
        System.out.println(searchInsert(a, 0));
        System.out.println(searchInsert(a, 4));
        System.out.println(searchInsert(b, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = left + ((right - left) >> 1);
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

}