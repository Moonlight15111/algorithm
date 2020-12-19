package com.moonlight.algorithm.train.greedy;

/**
 * 〈功能简述〉<br>
 * 〈给定一个非负整数数组，你最初位于数组的第一个位置
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * 来源：力扣（LeetCode）
 * 原题：https://leetcode-cn.com/problems/jump-game/
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 * @Author Moonlight
 * @Date 2020/8/31 22:20
 * @Version V1.0
 **/
public class JumpGame_1 {

    public static void main(String[] args) {
        int[] test1 = {2, 3, 1, 1, 4};
        int[] test2 = {3, 2, 1, 0, 4};
        System.out.println(jump(test1)); // true
        System.out.println(jump(test2)); // false
    }

    public static boolean jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 1, length = nums.length; i < length; i++) {
            if (max > length) {
                return true;
            }
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }

}
