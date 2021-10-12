package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kLl5u1/
 *
 * 给定一个已按照 升序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。
 * numbers 的下标 从 0 开始计数 ，所以答案数组应当满足 0 <= answer[0] < answer[1] < numbers.length 。
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 *
 * 输入：numbers = [1,2,4,6,10], target = 8  输出：[1,3]
 * 解释：2 与 6 之和等于目标数 8 。因此 index1 = 1, index2 = 3 。
 *
 * 输入：numbers = [2,3,4], target = 6  输出：[0,2]
 *
 * 输入：numbers = [-1,0], target = -1  输出：[0,1]
 *
 * @ClassName TwoSumII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/12 21:02
 * @Version V1.0
 **/
public class TwoSumII {

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6, 10}, b = {2, 3, 4}, c = {-1, 0};
        System.out.println(Arrays.toString(twoSum(a, 8)));
        System.out.println(Arrays.toString(twoSum(b, 6)));
        System.out.println(Arrays.toString(twoSum(c, -1)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1, s;
        while (l < r) {
            s = numbers[l] + numbers[r];
            if (target > s) {
                l++;
            } else if (target < s) {
                r--;
            } else {
                return new int[]{l, r};
            }
        }
        return new int[]{-1, -1};
    }

}
