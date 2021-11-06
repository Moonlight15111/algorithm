package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 *
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * 输入：nums = [1,2,3,1,1,3]   输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 * 输入：nums = [1,1,1,1]  输出：6
 * 解释：数组中的每组数字都是好数对
 *
 * 输入：nums = [1,2,3]  输出：0
 *
 * @ClassName NumIdenticalPairs
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/6 12:10
 * @Version V1.0
 **/
public class NumIdenticalPairs {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1, 1, 3}, b = {1, 1, 1, 1}, c = {1, 2, 3};
        System.out.println(numIdenticalPairs(a));
        System.out.println(numIdenticalPairs(b));
        System.out.println(numIdenticalPairs(c));
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] cnt = new int[101];
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (cnt[nums[i]] > 0) {
                ans += cnt[nums[i]];
            }
            cnt[nums[i]]++;
        }
        return ans;
    }

}