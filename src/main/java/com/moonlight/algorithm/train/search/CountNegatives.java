package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/count-negative-numbers-in-a-sorted-matrix/
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * 请你统计并返回 grid 中 负数 的数目。
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]  输出：8
 * 解释：矩阵中共有 8 个负数。
 *
 * 输入：grid = [[3,2],[1,0]]  输出：0
 *
 * 输入：grid = [[1,-1],[-1,-1]]  输出：3
 *
 * @author Moonlight
 */
public class CountNegatives {

    public static void main(String[] args) {
        int[][] a = {
                {4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}
        };
        System.out.println(nm(a) + ", " + countNegatives(a));
    }

    public static int countNegatives(int[][] grid) {
        int ans = 0, idx;
        for (int[] arr : grid) {
            idx = binarySearch(arr);
            ans += arr[idx] >= 0 ? 0 : grid[0].length - idx;
        }
        return ans;
    }

    private static int binarySearch(int[] arr) {
        int left = 0, right = arr.length - 1, mid;
        while (left < right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int nm(int[][] grid) {
        int ans = 0;
        for (int[] ints : grid) {
            for (int a : ints) {
                if (a < 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
