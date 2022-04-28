package com.moonlight.algorithm.train.recursion;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/beautiful-array/
 *
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * 那么数组 A 是漂亮数组。
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 *
 * 输入：4  输出：[2,1,4,3]
 *
 * 输入：5  输出：[3,1,2,5,4]
 *
 * @author Moonlight
 * @date 2022-04-28 13:58
 */
public class BeautifulArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(beautifulArray(4)));
        System.out.println(Arrays.toString(beautifulArray(5)));
    }

    public static int[] beautifulArray(int n) {
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        build(ans, 0, n - 1);
        return ans;
    }

    private static void build(int[] ans, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        build(ans, l, mid);
        build(ans, mid + 1, r);
        for (int i = l; i <= mid; i++) {
            ans[i] = 2 * ans[i] - 1;
        }
        for (int i = mid + 1; i <= r; i++) {
            ans[i] = 2 * ans[i];
        }
    }
}
