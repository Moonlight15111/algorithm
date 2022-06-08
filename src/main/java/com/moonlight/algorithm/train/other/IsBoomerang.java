package com.moonlight.algorithm.train.other;

/**
 * https://leetcode.cn/problems/valid-boomerang/
 *
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 *
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 *
 * 输入：points = [[1,1],[2,3],[3,2]]  输出：true
 *
 * 输入：points = [[1,1],[2,2],[3,3]]  输出：false
 *
 * @author Moonlight
 */
public class IsBoomerang {

    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{ {1, 1}, {2, 3}, {3, 2}}));
        System.out.println(isBoomerang(new int[][]{ {1, 1}, {2, 2}, {3, 3}}));
    }

    public static boolean isBoomerang(int[][] points) {
        // 向量叉乘 - 高中数学知识，但是忘记了
        int[] a = points[0], b = points[1], c = points[2];
        return (b[0] - a[0]) * (c[1] - b[1]) != (b[1] - a[1]) * (c[0] - b[0]);
    }

}
