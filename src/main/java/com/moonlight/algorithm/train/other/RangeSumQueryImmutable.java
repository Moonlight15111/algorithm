package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/range-sum-query-immutable/
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 * 实现 NumArray 类：
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，
 * 包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 * @author Moonlight
 * @date 2021/3/1 9:22
 */
public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        // -2, 0, 3, -5, 2, -1
        RangeSumQueryImmutable r = new RangeSumQueryImmutable(new int[]{-2, 0, 3, -5, 2, -1});
        // 1  -1  -3
        System.out.println(r.sumRange(0, 2));
        System.out.println(r.sumRange(2, 5));
        System.out.println(r.sumRange(0, 5));
    }

    private int[] sum;

    public RangeSumQueryImmutable(int[] nums) {
        // 前缀和
        this.sum = new int[nums.length];
        if (nums.length > 0) {
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if (i >= sum.length) {
            return 0;
        }
        return i > 0 ? sum[j] - sum[i - 1] : sum[j];
    }


}
