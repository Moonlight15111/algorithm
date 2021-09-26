package com.moonlight.algorithm.train.backtrack;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-eat-n-oranges/
 *
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 *     吃掉一个橘子。
 *     如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 *     如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 * 每天你只能从以上 3 种方案中选择一种方案。
 * 请你返回吃掉所有 n 个橘子的最少天数。
 *
 * 输入：n = 10  输出：4
 * 解释：你总共有 10 个橘子。
 *      第 1 天：吃 1 个橘子，剩余橘子数 10 - 1 = 9。
 *      第 2 天：吃 6 个橘子，剩余橘子数 9 - 2*(9/3) = 9 - 6 = 3。（9 可以被 3 整除）
 *      第 3 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。
 *      第 4 天：吃掉最后 1 个橘子，剩余橘子数 1 - 1 = 0。
 *      你需要至少 4 天吃掉 10 个橘子。
 *
 * 输入：n = 6  输出：3
 * 解释：你总共有 6 个橘子。
 *      第 1 天：吃 3 个橘子，剩余橘子数 6 - 6/2 = 6 - 3 = 3。（6 可以被 2 整除）
 *      第 2 天：吃 2 个橘子，剩余橘子数 3 - 2*(3/3) = 3 - 2 = 1。（3 可以被 3 整除）
 *      第 3 天：吃掉剩余 1 个橘子，剩余橘子数 1 - 1 = 0。
 *      你至少需要 3 天吃掉 6 个橘子。
 *
 * 输入：n = 56  输出：6
 *
 */
public class MinDays {

    public static void main(String[] args) {
        System.out.println(recursion(10) + ", " + cache(10) + ", " + cache222(10));
        System.out.println(recursion(6) + ", " + cache(6) + ", " + cache222(6));
        System.out.println(recursion(56) + ", " + cache(56) + ", " + cache222(56));
    }

    public static int cache222(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        m.put(1, 1);
        return cache222(n, m);
    }

    private static int cache222(int n, Map<Integer, Integer> m) {
        Integer ans = m.get(n);
        if (ans != null) {
            return ans;
        }
        int a = cache222(n / 2, m) + n % 2;
        int b = cache222(n / 3, m) + n % 3;
        ans = Math.min(a, b) + 1;
        m.put(n, ans);
        return ans;
    }


    public static int cache(int n) {
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 0);
        m.put(1, 1);
        return cache(n, m);
    }

    private static int cache(int n, Map<Integer, Integer> m) {
        if (m.containsKey(n)) {
            return m.get(n);
        }
        int a = cache(n - 1, m);
        if ((n % 2) == 0) {
            a = Math.min(a, cache(n - (n / 2), m));
        }
        if ((n % 3) == 0) {
            int e = 2 * (n / 3);
            a = Math.min(a, cache(n - e, m));
        }
        m.put(n, a + 1);
        return a + 1;
    }

    public static int recursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = recursion(n - 1);
        if ((n % 2) == 0) {
            a = Math.min(a, recursion(n - (n / 2)));
        }
        if ((n % 3) == 0) {
            int e = 2 * (n / 3);
            a = Math.min(a, recursion(n - e));
        }
        return a + 1;
    }

}
