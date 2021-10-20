package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-difference-lcci/
 *
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出：3，即数值对(11, 8)
 *
 */
public class SmallestDifference {

    public static void main(String[] args) {
        int[] a = {1, 3, 15, 11, 2}, b = {23, 127, 235, 19, 8};
        System.out.println(violence(a, b) + ", " + smallestDifference(a, b));
    }

    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long ans = Long.MAX_VALUE;
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return 0;
            } else if (a[i] > b[j]) {
                ans = Math.min(ans, Math.abs((long)a[i] - (long)b[j]));
                j++;
            } else {
                ans = Math.min(ans, Math.abs((long)a[i] - (long)b[j]));
                i++;
            }
        }
        return (int)ans;
    }

    public static int violence(int[] a, int[] b) {
        long ans = Long.MAX_VALUE;
        for (int x : a) {
            for (int y : b) {
                ans = Math.min(ans, Math.abs((long)x - (long)y));
            }
        }
        return (int)ans;
    }

}
