package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 * @ClassName Search
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/11 17:13
 * @Version V1.0
 **/
public class Search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1, mid = 0, count = 0;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                count++;
                break;
            }
        }

        left = mid - 1;
        while (left >= 0 && nums[left--] == target) {
            count++;
        }

        right = mid + 1;
        while (right < nums.length && nums[right++] == target) {
            count++;
        }

        return count;
    }

}
