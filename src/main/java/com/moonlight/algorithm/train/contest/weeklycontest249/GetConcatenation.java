package com.moonlight.algorithm.train.contest.weeklycontest249;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，
 * 数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
 *    ans[i] == nums[i]
 *    ans[i + n] == nums[i]
 * 具体而言，ans 由两个 nums 数组 串联 形成。
 * 返回数组 ans 。
 *
 * 输入：nums = [1,2,1]
 * 输出：[1,2,1,1,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 *
 * 输入：nums = [1,3,2,1]
 * 输出：[1,3,2,1,1,3,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 *
 * @ClassName GetConcatenation
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/7/11 11:28
 * @Version V1.0
 **/
public class GetConcatenation {

    public static void main(String[] args) {
        int[] a = {1, 2, 1}, b = {1, 3, 2, 1};
        System.out.println(Arrays.toString(getConcatenation(a)));
        System.out.println(Arrays.toString(getConcatenation(b)));
    }

    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n << 1];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

}