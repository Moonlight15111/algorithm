package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 *
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 输入: [1,2,3,4,5]  输出: True
 *
 * 输入: [0,0,1,2,5]  输出: True
 *
 */
public class IsStraight {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5}, b = {0, 0, 1, 2, 5}, c = {0, 0, 8, 5, 4};
        System.out.println(isStraight(a));
        System.out.println(isStraight(b));
        System.out.println(isStraight(c));
    }

    public static boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;

        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return nums[4] - nums[zero] < 5;
    }

}