package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * <p>
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1  输出：3
 * 解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
 * 现在需要制作 3 束花，每束只需要 1 朵。
 * 1 天后：[x, _, _, _, _]   // 只能制作 1 束花
 * 2 天后：[x, _, _, _, x]   // 只能制作 2 束花
 * 3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
 * <p>
 * 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2  输出：-1
 * 解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
 * <p>
 * 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3   输出：12
 * 解释：要制作 2 束花，每束需要 3 朵。
 * 花园在 7 天后和 12 天后的情况如下：
 * 7 天后：[x, x, x, x, _, x, x]
 * 可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
 * 12 天后：[x, x, x, x, x, x, x]
 * 显然，我们可以用不同的方式制作两束花。
 * <p>
 * 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1  输出：1000000000
 * 解释：需要等 1000000000 天才能采到花来制作花束
 * <p>
 * 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2  输出：9
 *
 * @ClassName MinDays
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/9 12:12
 * @Version V1.0
 **/
public class MinDays {

    public static void main(String[] args) {
        int[] a = {1, 10, 3, 10, 2}, b = {7, 7, 7, 7, 12, 7, 7}, c = {1000000000, 1000000000}, d = {1, 10, 2, 9, 3, 8, 4, 7, 5, 6};
        System.out.println(minDays(a, 3, 1));
        System.out.println(minDays(a, 3, 2));
        System.out.println(minDays(b, 2, 3));
        System.out.println(minDays(c, 1, 1));
        System.out.println(minDays(d, 4, 2));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        // 制作花朵最少的时间必然是 bloomDay 数组中开花所用天数最少的那朵花 min(bloomDay)
        // 制作花朵最多的时间也只能是 bloomDay 数组中开花所需天数最多的那朵花 max(bloomDay)
        // 寻找制作花束的最少天数必然落在区间 [min(bloomDay), max(bloomDay)] 连续的一个正整数区间, 因此可以用二分查找
        // 每当二分确定一个天数，就遍历数组看是否能凑成花束，能凑成则说明该天数可以，但可能还有更短的天数还能凑成，所以继续缩小范围，直到确定到具体某一天
        // 定义一个flowerCount标记相邻有几朵花已经盛开，如果相邻k朵花盛开了，那么就说明此时可以凑一束花
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, mid;
        for (int value : bloomDay) {
            min = Math.min(value, min);
            max = Math.max(value, max);
        }

        while (min < max) {
            mid = min + ((max - min) >>> 1);
            if (makeFlower(bloomDay, mid, m, k)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    private static boolean makeFlower(int[] bloomDay, int mid, int m, int k) {
        // 连续的花朵数量     花束的数量
        int flowerCount = 0, bouquet = 0;

        for (int n : bloomDay) {
            if (n <= mid) {
                flowerCount++;
                if (flowerCount == k) {
                    bouquet++;
                    flowerCount = 0;
                }
            } else {
                flowerCount = 0;
            }
            if (bouquet >= m) {
                break;
            }
        }

        return bouquet >= m;
    }

}
