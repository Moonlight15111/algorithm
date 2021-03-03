package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/4sum-ii/
 * <p>
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 输入:            输出:  2
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 *
 * @author Moonlight
 * @date 2021/3/3 17:27
 */
public class FourSumCount {

    public static void main(String[] args) {
        int[] a = {1, 2}, b = {-2, -1}, c = {-1, 2}, d = {0, 2};
        System.out.println(fourSumCount(a, b, c, d));
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 求出 A 和 B 任意两数之和 sumAB，以 sumAB 为 key，sumAB 出现的次数为 value，存到 map。
        // 然后计算 C 和 D 中任意两数之和取负sumCD，在 map 中查找是否存在 key 为 sumCD
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int res = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-(c + d))) {
                    res += map.get(-(c + d));
                }
            }
        }

        return res;
    }

}
