package com.moonlight.algorithm.train.search;

/**
 * https://leetcode.cn/problems/koko-eating-bananas/
 *
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 *
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 *
 * 输入：piles = [3,6,7,11], h = 8  输出：4
 *
 * 输入：piles = [30,11,23,4,20], h = 5  输出：30
 *
 * 输入：piles = [30,11,23,4,20], h = 6  输出：23
 *
 * @author Moonlight
 */
public class MinEatingSpeed {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        // 1. 所有香蕉加起来 <= k * h
        // 2. 1 <= k <= piles[Max] 即最少每小时吃一个，最多每小时吃piles中数量最多的香蕉
        // 3. 每堆香蕉的耗时 = 香蕉数量 / k  因为每小时只能选择一堆香蕉，不能整除时应该向上取整
        int l = 1, r = 0, m;
        for (int p : piles) {
            r = Math.max(p, r);
        }
        while (l < r) {
            m = l + (r - l) / 2;
            if (sum(piles, m) > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private static int sum(int[] piles, int m) {
        int sum = 0;
        for (int p : piles) {
            sum += (p % m == 0 ? p / m : p / m + 1);
        }
        return sum;
    }

}