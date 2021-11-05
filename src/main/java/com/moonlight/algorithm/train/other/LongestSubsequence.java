package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
 *
 * 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。
 *
 * 输入：arr = [1,2,3,4], difference = 1 输出：4
 * 解释：最长的等差子序列是 [1,2,3,4]。
 *
 * 输入：arr = [1,3,5,7], difference = 1  输出：1
 * 解释：最长的等差子序列是任意单个元素。
 *
 * 输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2  输出：4
 * 解释：最长的等差子序列是 [7,5,3,1]。
 *
 * @author Moonlight
 */
public class LongestSubsequence {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4}, b = {1, 3, 5, 7}, c = {1, 5, 7, 8, 5, 3, 4, 2, 1};
        System.out.println(longestSubsequence(a, 1));
        System.out.println(longestSubsequence(b, 1));
        System.out.println(longestSubsequence(c, -2));
    }

    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 1, getOrDefault;
        // 根据推算在 n 之前是否有 n - difference，且 n - difference 最长有多长来判断 n 能取到的最长长度
        for (int n : arr) {
            getOrDefault = map.getOrDefault(n - difference, 0) + 1;
            ans = Math.max(ans, getOrDefault);
            map.put(n, getOrDefault);
        }
        return ans;
    }

}