package com.moonlight.algorithm.train.cnt;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals/
 *
 * 给你一个整数数组 arr 和一个整数 k 。现需要从数组中恰好移除 k 个元素，请找出移除后数组中不同整数的最少数目。
 *
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k <= arr.length
 *
 * 输入：arr = [5,5,4], k = 1  输出：1
 * 解释：移除 1 个 4 ，数组中只剩下 5 一种整数。
 *
 * 输入：arr = [4,3,1,1,3,3,2], k = 3  输出：2
 * 解释：先移除 4、2 ，然后再移除两个 1 中的任意 1 个或者三个 3 中的任意 1 个，最后剩下 1 和 3 两种整数。
 *
 * @ClassName FindLeastNumOfUniqueInts
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/7 12:43
 * @Version V1.0
 **/
public class FindLeastNumOfUniqueInts {

    public static void main(String[] args) {
        int[] a = {5, 5, 4}, b = {4, 3, 1, 1, 3, 3, 2};
        System.out.println(findLeastNumOfUniqueInts(a, 1));
        System.out.println(findLeastNumOfUniqueInts(b, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        int ans = list.size();
        for (Map.Entry<Integer, Integer> e : list) {
            if (k >= e.getValue()) {
                k -= e.getValue();
                ans--;
            }
        }
        return ans;
    }

}
