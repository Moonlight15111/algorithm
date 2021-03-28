package com.moonlight.algorithm.train.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 *
 * 给你一个偶数 n，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr​​ 赋值​​给 perm 。
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 * <p>
 * 输入：n = 2  输出：1
 * 解释：最初，perm = [0,1]
 * 第 1 步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 * <p>
 * 输入：n = 4  输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1 步操作后，perm = [0,2,1,3]
 * 第 2 步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 * <p>
 * 输入：n = 6  输出：4
 *
 * @ClassName ReinitializePermutation
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/28 11:03
 * @Version V1.0
 **/
public class ReinitializePermutation {

    public static void main(String[] args) {
        // 1
        System.out.println(reinitializePermutation(2));
        // 2
        System.out.println(reinitializePermutation(4));
        // 4
        System.out.println(reinitializePermutation(6));
        // 10
        System.out.println(reinitializePermutation(12));
        // 6
        System.out.println(reinitializePermutation(10));
    }

    public static int reinitializePermutation(int n) {
        int res = 0;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        int[] ori = Arrays.copyOf(perm, n), arr;
        while (true) {
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            res++;
            if(Arrays.equals(ori, arr)){
                return res;
            }
            perm = arr;
        }
    }

}
