package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 *
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r
 * 都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * 输入：nums = [1,3,5,4,7]   输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * 输入：nums = [2,2,2,2,2]   输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *
 * @ClassName FindLengthOfLCIS
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/19 23:52
 * @Version V1.0
 **/
public class FindLengthOfLCIS {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 4, 7}, b = {2, 2, 2, 2, 2}, c = {1, 2, 2, 2, 2, 3, 3, 4};
        System.out.println(findLengthOfLCIS(a));
        System.out.println(findLengthOfLCIS(b));
        System.out.println(findLengthOfLCIS(c));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }

}
