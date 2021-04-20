package com.moonlight.algorithm.train.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 *       其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1   输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 * 提示:
 *      1 <= strs.length <= 600
 *      1 <= strs[i].length <= 100
 *      strs[i] 仅由 '0' 和 '1' 组成
 *      1 <= m, n <= 100
 *
 * @author Moonlight
 * @date 2021/4/20 13:06
 */
public class OnesAndZeroes {

    public static void main(String[] args) {
        String[] a = {"10", "0001", "111001", "1", "0"}, b = {"10", "0", "1"};
        // 4
        System.out.println(findMaxForm(a, 5, 3) + ",  " + findMaxForm123(a, 5, 3));
        // 3
        System.out.println(findMaxForm(a, 4, 3) + ",  " + findMaxForm123(a, 4, 3));
        // 2
        System.out.println(findMaxForm(b, 1, 1) + ",  " + findMaxForm123(b, 1, 1));
    }

    public static int findMaxFormDp(String[] strs, int m, int n) {
        // todo dp
        return 0;
    }

    public static int findMaxForm123(String[] strs, int m, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(i, new int[]{zeroCount(strs[i]), oneCount(strs[i])});
        }
        int[][][] dp = new int[m + 1][n + 1][strs.length + 1];
        for (int[][] a : dp) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }
        return process(strs, 0, m, n, map, dp);
    }

    private static int process(String[] strs, int cur, int restZero, int restOne, Map<Integer, int[]> map, int[][][] dp) {
        if (restZero < 0 || restOne < 0 || cur >= strs.length) {
            dp[restZero][restOne][cur] = 0;
            return 0;
        }
        if (dp[restZero][restOne][cur] != -1) {
            return dp[restZero][restOne][cur];
        }
        int res = process(strs, cur + 1, restZero, restOne, map, dp);
        int[] count = map.get(cur);
        if (restZero - count[0] >= 0 && restOne - count[1] >= 0) {
            res = Math.max(res, 1 + process(strs, cur + 1, restZero - count[0], restOne - count[1], map, dp));
        }
        dp[restZero][restOne][cur] = res;
        return res;
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        // timeout
        return process(strs, 0, m, n);
    }

    private static int process(String[] strs, int cur, int restZero, int restOne) {
        if (restZero < 0 || restOne < 0 || cur >= strs.length) {
            return 0;
        }

        int res = process(strs, cur + 1, restZero, restOne);
        if (restZero - zeroCount(strs[cur]) >= 0 && restOne - oneCount(strs[cur]) >= 0) {
            res = Math.max(res, 1 + process(strs, cur + 1, restZero - zeroCount(strs[cur]), restOne - oneCount(strs[cur])));
        }
        return res;
    }

    public static int zeroCount(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                res++;
            }
        }
        return res;
    }

    public static int oneCount(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                res++;
            }
        }
        return res;
    }
}
