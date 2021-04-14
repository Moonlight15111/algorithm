package com.moonlight.algorithm.train.other;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/third-maximum-number/
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 输入：[3, 2, 1]  输出：1
 * 解释：第三大的数是 1 。
 *
 * 输入：[1, 2]   输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 输入：[2, 2, 3, 1]  输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * @ClassName ThirdMaxNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/13 22:00
 * @Version V1.0
 **/
public class ThirdMaxNumber {

    public static void main(String[] args) {
        int[] a = {3, 2, 1}, b = {1, 2}, c = {2, 2, 3, 1};
        System.out.println(thirdMax(a));
        System.out.println(thirdMax(b));
        System.out.println(thirdMax(c));
    }

    public static int thirdMax(int[] nums) {
        long x = Long.MIN_VALUE, y = Long.MIN_VALUE, z = Long.MIN_VALUE;
        for (int n : nums) {
            if (n == x|| n == y || n == z) {
                continue;
            }
            if (n > x) {
                z = y;
                y = x;
                x = n;
            } else if (n > y) {
                z = y;
                y = n;
            } else if (n > z) {
                z = n;
            }
        }

        return (int) (z == Long.MIN_VALUE ? x : z);
    }

}
