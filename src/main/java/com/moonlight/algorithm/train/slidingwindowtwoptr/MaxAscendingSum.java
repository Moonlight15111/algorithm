package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，
 * 则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 * 输入：nums = [10,20,30,5,10,50]  输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 *
 * 输入：nums = [10,20,30,40,50]   输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 *
 * 输入：nums = [12,17,15,13,10,11,12]    输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 *
 * 输入：nums = [100,10,1]  输出：100
 *
 * @ClassName MaxAscendingSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/21 10:32
 * @Version V1.0
 **/
public class MaxAscendingSum {

    public static void main(String[] args) {
        int[] a = {10,20,30,5,10,50}, b = {10,20,30,40,50}, c = {12,17,15,13,10,11,12}, d = {100,10,1};
        System.out.println(maxAscendingSum(a) + ", " + maxAscendingSum1231(a));
        System.out.println(maxAscendingSum(b) + ", " + maxAscendingSum1231(b));
        System.out.println(maxAscendingSum(c) + ", " + maxAscendingSum1231(c));
        System.out.println(maxAscendingSum(d) + ", " + maxAscendingSum1231(d));
    }

    public static int maxAscendingSum1231(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = 0, cur = 0, prev = 0;
        for (int n : nums) {
            if (n <= prev) {
                cur = 0;
            }
            prev = n;
            cur += n;
            res = Math.max(res, cur);
        }
        return res;
    }

    public static int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = nums[0], max = nums[0];
        for (int i = 1, len = nums.length; i < len; i++) {
            max = Math.max(sum, max);
            if (nums[i] > nums[i - 1] ) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
        }
        return Math.max(sum, max);
    }

}
