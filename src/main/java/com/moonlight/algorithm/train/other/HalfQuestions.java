package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/WqXACV/
 *
 * 有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。主办方提供了 2*N 道题目，
 * 整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
 * 若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
 *
 * questions.length == 2*n
 * 2 <= questions.length <= 10^5
 * 1 <= questions[i] <= 1000
 *
 * 输入：questions = [2,1,6,2]  输出：1
 * 解释：有 2 位扣友在 4 道题目中选择 2 题。
 * 可选择完成知识点类型为 2 的题目时，此时仅一种知识点类型
 * 因此至少包含 1 种知识点类型。
 *
 * 输入：questions = [1,5,1,3,4,5,2,5,3,3,8,6] 输出：2
 * 解释：有 6 位扣友在 12 道题目中选择题目，需要选择 6 题。
 * 选择完成知识点类型为 3、5 的题目，因此至少包含 2 种知识点类型。
 *
 * @author Moonlight
 */
public class HalfQuestions {

    public static void main(String[] args) {
        System.out.println(halfQuestions(new int[]{2, 1, 6, 2}));
        System.out.println(halfQuestions(new int[]{1, 5, 1, 3, 4, 5, 2, 5, 3, 3, 8, 6}));
    }

    public static int halfQuestions(int[] questions) {
        // 题目翻译的有问题，大体意思应该是：给定一个整数数组,统计数组中出现的元素的个数,返回 元素个数和 为至少 1/2数组长 的 元素数量
        int[] cnt = new int[10001];
        for (int q : questions) {
            cnt[q]++;
        }
        int sum = 0, ans = 0;
        Arrays.sort(cnt);
        for (int i = cnt.length - 1, n = questions.length; i >= 0; i--) {
            sum += cnt[i];
            ans++;
            if (sum >= n/2) {
                break;
            }
        }
        return ans;
    }

}
