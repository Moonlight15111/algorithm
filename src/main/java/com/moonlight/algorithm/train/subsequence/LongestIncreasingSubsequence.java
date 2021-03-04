package com.moonlight.algorithm.train.subsequence;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]   输出：4   解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 输入：nums = [0,1,0,3,2,3]   输出：4
 *
 * 输入：nums = [7,7,7,7,7,7,7]  输出：1
 *s
 * @author Moonlight
 * @date 2021/3/4 10:50
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18}, b = {0, 1, 0, 3, 2, 3}, c = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS(b));
        System.out.println(lengthOfLIS(c));

        System.out.println(lengthOfLISBinarySearch(a));
        System.out.println(lengthOfLISBinarySearch(b));
        System.out.println(lengthOfLISBinarySearch(c));
    }

    public static int lengthOfLISBinarySearch(int[] nums) {
        // 贪心 + 二分
        int length = nums.length, dpEnd = 0;
        int[] dp = new int[length];
        dp[0] = nums[0];

        for (int i = 0; i < length; i++) {
            if (nums[i] > dp[dpEnd]) {
                dpEnd++;
                dp[dpEnd] = nums[i];
            } else {
                int left = 0, right = dpEnd, mid;
                while (left < right) {
                    mid = left + (right - left >>> 1);
                    if (nums[i] > dp[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = nums[i];
            }
        }
        dpEnd++;
        return dpEnd;
    }

    public static int lengthOfLIS(int[] nums) {
        int length = nums.length, res = 0, max;

        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        for(int i = 1; i < length; i++){
            max = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }

        for (int a : dp) {
            res = res < a ? a : res;
        }

        return res;
    }

}
