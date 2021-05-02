package com.moonlight.algorithm.train.contest.weeklycontest239;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，
 * 请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 * 返回 abs(i - start) 。
 * 题目数据保证 target 存在于 nums 中。
 *
 * 输入：nums = [1,2,3,4,5], target = 5, start = 3   输出：1
 * 解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
 *
 * 输入：nums = [1], target = 1, start = 0  输出：0
 * 解释：nums[0] = 1 是唯一一个等于 target 的值，所以答案是 abs(0 - 0) = 1 。
 *
 * 输入：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0  输出：0
 * 解释：nums 中的每个值都是 1 ，但 nums[0] 使 abs(i - start) 的结果得以最小化，所以答案是 abs(0 - 0) = 0 。
 *
 *
 * @ClassName GetMinDistance
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/2 10:32
 * @Version V1.0
 **/
public class GetMinDistance {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5}, b = {1}, c = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(getMinDistance(a, 5, 3));
        System.out.println(getMinDistance(b, 1, 0));
        System.out.println(getMinDistance(c, 1, 0));
    }

    public static int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(Math.abs(i - start), ans);
            }
        }
        return ans;
    }

}
