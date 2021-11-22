package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k],
 * nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10^4 <= target <= 10^4
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0  输出：4
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3  输出：-1
 *
 * 输入：nums = [1], target = 0  输出：-1
 *
 * @author Moonlight
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2}, b = {1};
        System.out.println(search(a, 0));
        System.out.println(search(a, 3));
        System.out.println(search(b, 0));
    }

    public static int search(int[] nums, int target) {
        int mid = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                mid = i;
                break;
            }
        }
        int ans = search(nums, target, 0, mid);
        if (ans == -1) {
            return search(nums, target, mid, nums.length);
        }
        return ans;
    }

    private static int search(int[] nums, int target, int left, int right) {
        int ans = -1, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left++;
            } else if (nums[mid] > target) {
                right--;
            } else {
                return mid;
            }
        }
        return ans;
    }

}
