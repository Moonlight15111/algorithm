package com.moonlight.algorithm.train.sort;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/reduce-array-size-to-the-half/
 *
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 *
 * 输入：arr = [3,3,3,3,5,5,5,2,2,7]  输出：2
 * 解释：选择 {3,7} 使得结果数组为 [5,5,5,2,2]、长度为 5（原数组长度的一半）。
 * 大小为 2 的可行集合有 {3,5},{3,2},{5,2}。
 * 选择 {2,7} 是不可行的，它的结果数组为 [3,3,3,3,5,5,5]，新数组长度大于原数组的二分之一。
 *
 * 输入：arr = [7,7,7,7,7,7] 输出：1
 * 解释：我们只能选择集合 {7}，结果数组为空。
 *
 * 输入：arr = [1,9]  输出：1
 *
 * 输入：arr = [1000,1000,3,7] 输出：1
 *
 * 输入：arr = [1,2,3,4,5,6,7,8,9,10]  输出：5
 *
 * @author Moonlight
 */
public class MinSetSize {

    public static void main(String[] args) {
        int[] a = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}, b = {7, 7, 7, 7, 7, 7},
              c = {1, 9}, d = {1000, 1000, 3, 7}, e = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(minSetSize(a));
        System.out.println(minSetSize(b));
        System.out.println(minSetSize(c));
        System.out.println(minSetSize(d));
        System.out.println(minSetSize(e));
    }

    public static int minSetSize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        int ans = 0, sum = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            ans++;
            sum += list.get(i).getValue();
            if (sum >= arr.length / 2) {
                break;
            }
        }
        return ans;
    }

}