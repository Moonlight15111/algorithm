package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 输入: 2  输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 输入: 10  输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(recursion(8) + ", " + cache(8));
        System.out.println(recursion(2) + ", " + cache(2));
        System.out.println(recursion(10) + ", " + cache(10));
    }

    public static int cache(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, Integer.MIN_VALUE);
        return cache(n, cache);
    }

    private static int cache(int n, int[] cache) {
        if (cache[n] != Integer.MIN_VALUE) {
            return cache[n];
        }
        if (n == 2) {
            cache[n] = 1;
            return cache[n];
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * cache(n - i, cache)));
        }
        cache[n] = ans;
        return ans;
    }

    public static int recursion(int n) {
        if (n == 2) {
            return 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.max(i * (n - i), i * recursion(n - i)));
        }
        return ans;
    }

}