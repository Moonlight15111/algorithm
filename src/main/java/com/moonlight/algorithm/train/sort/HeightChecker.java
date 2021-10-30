package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/height-checker/
 *
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 *
 * 输入：heights = [1,1,4,2,1,3]  输出：3
 * 解释：高度：[1,1,4,2,1,3] 预期：[1,1,1,2,3,4]
 *      下标 2 、4 、5 处的学生高度不匹配。
 *
 * 输入：heights = [5,1,2,3,4] 输出：5
 * 解释：高度：[5,1,2,3,4] 预期：[1,2,3,4,5]
 *       所有下标的对应学生高度都不匹配。
 *
 * 输入：heights = [1,2,3,4,5]  输出：0
 * 解释 高度：[1,2,3,4,5] 预期：[1,2,3,4,5]
 *      所有下标的对应学生高度都匹配。
 *
 * @ClassName HeightChecker
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/30 12:14
 * @Version V1.0
 **/
public class HeightChecker {

    public static void main(String[] args) {
        int[] a = {1, 1, 4, 2, 1, 3}, b = {5, 1, 2, 3, 4}, c = {1, 2, 3, 4, 5};
        System.out.println(heightChecker(a));
        System.out.println(heightChecker(b));
        System.out.println(heightChecker(c));
    }

    public static int heightChecker(int[] heights) {
        int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }

}