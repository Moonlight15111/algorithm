package com.moonlight.algorithm.train;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/xor-queries-of-a-subarray/submissions/
 * 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * 对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。
 * 并返回一个包含给定查询 queries 所有结果的数组
 * 输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
 * 输出：[2,7,14,8]
 * 解释：
 *  数组中元素的二进制表示形式是：
 * 1 = 0001
 * 3 = 0011
 * 4 = 0100
 * 8 = 1000
 * 查询的 XOR 值为：
 * [0,1] = 1 xor 3 = 2
 * [1,2] = 3 xor 4 = 7
 * [0,3] = 1 xor 3 xor 4 xor 8 = 14
 * [3,3] = 8
 *
 * 输入：arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
 * 输出：[8,0,4,4]
 * @author Moonlight
 * @date 2020/12/16 14:34
 */
public class XorQueries {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(xorQueries(arr, queries)));
        System.out.println(Arrays.toString(xorQueries2(arr, queries)));

        int[] arr2 = {4, 8, 2, 10};
        int[][] queries2 = {{2, 3}, {1, 3}, {0, 0}, {0, 3}};
        System.out.println(Arrays.toString(xorQueries(arr2, queries2)));
        System.out.println(Arrays.toString(xorQueries2(arr2, queries2)));
    }

    public static int[] xorQueries2(int[] arr, int[][] queries) {
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        if (queries == null || queries.length < 1) {
            return new int[0];
        }
        // 因为 A ^ A = 0   A ^ 0 = A
        // 所以 XOR[L, R] = XOR[0, R] ^ XOR[0, L-1]
        // 先求每个位置的前缀异或和 xor[i] 表示前i项的异或和
        int[] xor = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            xor[i] = xor[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] nums : queries) {
            // 假设L,R为[1, 2]
            // 则xor[nums[0]] = arr[0] ^ 0   xor[nums[1] + 1] = arr[0] ^ arr[1] ^ arr[2]
            // 于是res[i++] = arr[1] ^ arr[2]
            res[i++] = xor[nums[0]] ^ xor[nums[1] + 1];
        }

        return res;
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        // 暴力破解  循环queries中的数组 然后去arr中截取进行 异或运算
        if (arr == null || arr.length < 1) {
            return new int[0];
        }
        if (queries == null || queries.length < 1) {
            return new int[0];
        }
        int[] ans = new int[queries.length];

        int[] query; int left, right, res = 0;
        for (int i = 0, length = queries.length; i < length; i++) {
            query = queries[i];
            if (query == null || query.length < 2 || query[1] < query[0] || query[1] > arr.length || query[0] > arr.length) {
                ans[i] = 0;
            } else {
                left = query[0];
                right = query[1];
                res = 0;
                if (left == right) {
                    ans[i] = arr[left];
                } else {
                    for (int j = left; j <= right; j++) {
                        res ^= arr[j];
                    }
                    ans[i] = res;
                }
            }
        }

        return ans;
    }

}
