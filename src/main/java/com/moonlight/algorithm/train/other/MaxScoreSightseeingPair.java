package com.moonlight.algorithm.train.other;

/**
 * https://leetcode.cn/problems/best-sightseeing-pair/
 *
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 *
 * 输入：values = [8,1,5,2,6]  输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 * 输入：values = [1,2]  输出：2
 *
 * @author Moonlight
 */
public class MaxScoreSightseeingPair {

    public static void main(String[] args) {
        System.out.println(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
        System.out.println(maxScoreSightseeingPair(new int[]{1, 2}));
    }

    public static int maxScoreSightseeingPair(int[] values) {
        // 将条件分解为 first = values[i] + i  second = values[j] - j 两个部分
        int fir = values[0], ans = 0;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, fir + values[i] - i);
            fir = Math.max(fir, values[i] + i);
        }
        return ans;
    }

}
