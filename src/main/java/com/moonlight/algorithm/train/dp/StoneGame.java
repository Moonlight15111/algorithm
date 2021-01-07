package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题: https://leetcode-cn.com/problems/stone-game/
 * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
 * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
 * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
 *
 * 输入：[5,3,4,5]     输出：true
 * 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
 * 如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
 *
 * 2 <= piles.length <= 500     piles.length 是偶数。     1 <= piles[i] <= 500       sum(piles) 是奇数。
 *
 * @author Moonlight
 * @date 2021/1/7 11:16
 */
public class StoneGame {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 5};
        System.out.println(stoneGame111(arr));
        System.out.println(stoneGame2222(arr));
    }

    public static boolean stoneGame(int[] piles) {
        // 因为 亚历克斯先开始  piles.length 是偶数
        return true;
    }


    public static boolean stoneGame111(int[] piles) {
        if (piles == null || piles.length == 0 || piles.length == 1) {
            return true;
        }
        return first111(piles, 0, piles.length - 1) > second111(piles, 0, piles.length - 1);
    }

    private static int first111(int[] piles, int left, int right) {
        if (left == right) {
            return piles[left];
        }
        return Math.max(piles[left] + second111(piles, left + 1, right), piles[right] + second111(piles, left, right - 1));
    }

    private static int second111(int[] piles, int left, int right) {
        if (left == right) {
            return 0;
        }
        return Math.min(first111(piles, left + 1, right), first111(piles, left, right - 1));
    }



    public static boolean stoneGame2222(int[] piles) {
        if (piles == null || piles.length == 0 || piles.length == 1) {
            return true;
        }
        int[][] firstDp = new int[piles.length][piles.length];
        for (int[] a : firstDp) {
            Arrays.fill(a, -1);
        }
        int[][] secondDp = new int[piles.length][piles.length];
        for (int[] a : secondDp) {
            Arrays.fill(a, -1);
        }
        return first222(piles, 0, piles.length - 1, firstDp) > second222(piles, 0, piles.length - 1, secondDp);
    }

    private static int first222(int[] piles, int left, int right, int[][] dp) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = piles[left];
            return dp[left][right];
        }
        dp[left][right] = Math.max(piles[left] + second222(piles, left + 1, right, dp), piles[right] + second222(piles, left, right - 1, dp));
        return dp[left][right];
    }

    private static int second222(int[] piles, int left, int right, int[][] dp) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = 0;
            return dp[left][right];
        }
        dp[left][right] = Math.min(first222(piles, left + 1, right, dp), first222(piles, left, right - 1, dp));
        return dp[left][right];
    }

}
