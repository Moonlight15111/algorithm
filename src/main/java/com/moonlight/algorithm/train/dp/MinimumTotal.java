package com.moonlight.algorithm.train.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/triangle/
 *
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于
 * 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]      输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 输入：triangle = [[-10]]  输出：-10
 *
 * @author Moonlight
 * @date 2021/1/11 10:05
 */
public class MinimumTotal {

    public static void main(String[] args) {
        List<List<Integer>> arg = new ArrayList<>();

        List<Integer> a = new ArrayList<>();
        a.add(2);

        List<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);

        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(5);
        c.add(7);

        List<Integer> d = new ArrayList<>();
        d.add(4);
        d.add(1);
        d.add(8);
        d.add(3);

        arg.add(a);
        arg.add(b);
        arg.add(c);
        arg.add(d);

        System.out.println(minimumTotal(arg));
        System.out.println(minimumTotal222(arg));
        System.out.println(dp(arg));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        return process(triangle, 0, 0);
    }

    // 当前在第index个List上，所在的位置为 i
    private static int process(List<List<Integer>> triangle, int index, int i) {
        if (index >= triangle.size() || i >= triangle.get(index).size()) {
            return 0;
        }
        int res = triangle.get(index).get(i);
        res += Math.min(process(triangle, index + 1, i), process(triangle, index + 1, i + 1));
        return res;
    }

    public static int minimumTotal222(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return process22(triangle, 0, 0, dp);
    }

    // 当前在第index个List上，所在的位置为 i
    private static int process22(List<List<Integer>> triangle, int index, int i, int[][] dp) {
        if (dp[index][i] != -1) {
            return dp[index][i];
        }
        if (index >= triangle.size() || i >= triangle.get(index).size()) {
            dp[index][i] = 0;
            return dp[index][i];
        }
        int res = triangle.get(index).get(i);
        res += Math.min(process22(triangle, index + 1, i, dp), process22(triangle, index + 1, i + 1, dp));
        dp[index][i] = res;
        return dp[index][i];
    }

    public static int dp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int rowMax = triangle.size(), colMax = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[rowMax + 1][colMax + 1];
        for (int i = 0; i < colMax + 1; i++) {
            dp[rowMax][i] = 0;
        }
        for (int i = 0; i < rowMax + 1; i++) {
            dp[i][colMax] = 0;
        }

        for (int i = rowMax - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

}