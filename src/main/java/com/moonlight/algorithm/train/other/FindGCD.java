package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-greatest-common-divisor-of-array/
 *
 * 给你一个整数数组 nums ，返回数组中最大数和最小数的 最大公约数 。
 * 两个数的 最大公约数 是能够被两个数整除的最大正整数。
 *
 * 输入：nums = [2,5,6,9,10]  输出：2
 * 解释：
 * nums 中最小的数是 2
 * nums 中最大的数是 10
 * 2 和 10 的最大公约数是 2
 *
 * 输入：nums = [7,5,6,8,3]  输出：1
 * 解释：
 * nums 中最小的数是 3
 * nums 中最大的数是 8
 * 3 和 8 的最大公约数是 1
 *
 * 输入：nums = [3,3]  输出：3
 * 解释：
 * nums 中最小的数是 3
 * nums 中最大的数是 3
 * 3 和 3 的最大公约数是 3
 *
 * @ClassName FindGCD
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/20 11:44
 * @Version V1.0
 **/
public class FindGCD {

    public static void main(String[] args) {
        int[] a = {2, 5, 6, 9, 10}, b = {7, 5, 6, 8, 3}, c = {3, 3};
        System.out.println(findGCD(a));
        System.out.println(findGCD(b));
        System.out.println(findGCD(c));
    }

    public static int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0], max = nums[nums.length - 1];

        for (int i = 1, d; i <= min; i++) {
            d = min / i;
            if (min % d == 0 && max % d == 0) {
                return d;
            }
        }

        return 1;
    }

}
