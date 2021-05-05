package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/relative-ranks/
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * (注：分数越高的选手，排名越靠前。)
 *
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 *      余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 *
 * @ClassName FindRelativeRanks
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/5 19:07
 * @Version V1.0
 **/
public class FindRelativeRanks {

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks(a)));
    }

    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        String[] ans = new String[n];
        for (int i = n - 1; i >= 0; i--) {
           if (i == n - 1) {
               ans[map.get(score[i])] = "Gold Medal";
           }  else if (i == score.length - 2) {
               ans[map.get(score[i])] = "Silver Medal";
           } else if (i == score.length - 3) {
               ans[map.get(score[i])] = "Bronze Medal";
           } else {
               ans[map.get(score[i])] = String.valueOf(score.length - i);
           }
        }
        return ans;
    }

    public static String[] err(int[] score) {
        // 搞错题目意思了
        sort(score);
        int n = score.length;
        String[] ans = new String[n];
        ans[0] = "Gold Medal";
        ans[1] = "Silver Medal";
        ans[2] = "Bronze Medal";
        for (int i = 3; i < n; i++) {
            ans[i] = i + 1 + "";
        }
        return ans;
    }

    private static void sort(int[] score) {
        buildHeap(score);
        int n = score.length, f;
        while (n > 0) {
            f = score[0];
            score[0] = score[n - 1];
            score[n - 1] = f;

            n--;
            heapify(score, 0, n);
        }
    }

    private static void heapify(int[] score, int i, int n) {
        int left = 2 * i + 1, largest, j;
        while (left < n) {
            largest = left + 1 < n && score[left] < score[left + 1] ? left + 1 : left;

            largest = score[i] > score[largest] ? i : largest;
            if (i == largest) {
                break;
            }

            j = score[i];
            score[i] = score[largest];
            score[largest] = j;

            i = largest;
            left = 2 * i + 1;
        }
    }

    private static void buildHeap(int[] score) {
        for (int i = 0, j, index, p; i < score.length; i++) {
            index = i;
            p = (index - 1) / 2;
            while (score[index] < score[p]) {
                j = score[index];
                score[index] = score[p];
                score[p] = j;
                index = p;
                p = (index - 1) / 2;
            }
        }
    }



}
