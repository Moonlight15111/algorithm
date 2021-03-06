package com.moonlight.algorithm.train.greedy;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *       从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 *
 * @author Moonlight
 * @date 2021/3/24 11:42
 */
public class JumpGame_2 {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4}, b = {1}, c = {2, 1}, d = {1, 2, 3};
        // 2
        System.out.println(jump(a));
        // 0
        System.out.println(jump(b));
        // 1
        System.out.println(jump(c));
        // 2
        System.out.println(jump(d));
    }

    public static int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        if (nums[0] >= nums.length) {
            return 1;
        }
        // 找每次可以到达的最远的位置
        int res = 0, start = 0, end = 0, length = nums.length;
        // 不能取到最后一个位置，因为end可能正好为最后一个位置，这种情况下会多增加一次
        // 计数，导致过不了AC
        for (int i = 0; i < length - 1; i++) {
            start = Math.max(start, nums[i] + i);
            if (end == i) {
                res++;
                end = start;
            }
        }
        return res;
    }

}