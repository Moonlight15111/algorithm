package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 输入：nums = [2,6,4,8,10,9,15]  输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 输入：nums = [1,2,3,4]  输出：0
 *
 * 输入：nums = [1]  输出：0
 *
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 *
 * @ClassName FindUnsortedSubarray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 12:50
 * @Version V1.0
 **/
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        int[] a = {2, 6, 4, 8, 10, 9, 15}, b = {1, 2, 3, 4}, c = {1};
        System.out.println(findUnsortedSubarray(a));
        System.out.println(findUnsortedSubarray(b));
        System.out.println(findUnsortedSubarray(c));
    }

    public static int findUnsortedSubarray(int[] nums) {
        // 确定子数组左右的位置
        // 从左到右滑一次，记录最右的小于之前最大的数的位置
        // 从右到左再滑一次，记录最左的大于之前最小的数的位置
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int cur = nums[0], n = nums.length, l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < cur) {
                r = i;
            } else {
                cur = Math.max(cur, nums[i]);
            }
        }
        cur = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > cur) {
                l = i;
            } else {
                cur = Math.min(cur, nums[i]);
            }
        }
        return r == l ? r : r - l + 1;
    }

}
