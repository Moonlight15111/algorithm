package com.moonlight.algorithm.train.presum;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * 以数组形式返回答案。
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 *
 * 输入：nums = [8,1,2,2,3]  输出：[4,0,1,1,3]
 *
 * 输入：nums = [6,5,4,8]  输出：[2,1,0,3]
 *
 * 输入：nums = [7,7,7,7]  输出：[0,0,0,0]
 *
 * @author Moonlight
 */
public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {
        int[] a = {8, 1, 2, 2, 3}, b = {6, 5, 4, 8}, c = {7, 7, 7, 7}, d = {5, 0, 10, 0, 10, 6};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(a)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(b)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(c)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(d)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int[] cnt = new int[101];
        // 词频统计 + 类前缀和
        for (int n : nums) {
            cnt[n]++;
        }
        for (int i = 1; i < 101; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ans;
    }

}