package com.moonlight.algorithm.train.dp;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/predict-the-winner/
 * 给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数
 * 然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最
 * 最终获得分数总和最多的玩家获胜。
 * 给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。
 *
 * 输入：[1, 5, 2]   输出：False
 * 解释：一开始，玩家1可以从1和2中进行选择。如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。
 * 如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
 * 因此，玩家 1 永远不会成为赢家，返回 False 。
 *
 * 输入：[1, 5, 233, 7]  输出：True
 * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
 *      最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
 *
 * 1 <= 给定的数组长度 <= 20.
 * 数组里所有分数都为非负数且不会大于 10000000 。
 * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 *
 * @author Moonlight
 * @date 2021/1/7 12:04
 */
public class PredictTheWinner {

    public static void main(String[] args) {
        int[] arr = {1, 5, 233, 7};
        int[] arr121 = {1, 5, 2};
        System.out.println(predictTheWinner(arr));
        System.out.println(predictTheWinner(arr121));

        System.out.println(dp(arr));
        System.out.println(dp(arr121));
    }

    public static boolean dp(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int length = nums.length;
        int[][] firstDp = new int[length][length];
        for (int i = 0; i < length; i++) {
            firstDp[i][i] = nums[i];
        }
        int[][] secondDp = new int[length][length];
        int row, col;
        for (int i = 1; i < length; i++) {
            row = 0;
            col = i;
            while (row < length && col < length) {
                firstDp[row][col] = Math.max(nums[row] + secondDp[row + 1][col], nums[col] + secondDp[row][col - 1]);
                secondDp[row][col] = Math.min(firstDp[row + 1][col], firstDp[row][col - 1]);
                col++;
                row++;
            }
        }

        return firstDp[0][length - 1] >= secondDp[0][length - 1];
    }

    public static boolean predictTheWinner(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return true;
        }
        int[][] firstDp = new int[nums.length][nums.length];
        for (int[] a : firstDp) {
            Arrays.fill(a, -1);
        }
        int[][] secondDp = new int[nums.length][nums.length];
        for (int[] a : secondDp) {
            Arrays.fill(a, -1);
        }
        return first(nums, 0, nums.length - 1, firstDp) >= second(nums, 0, nums.length - 1, secondDp);
    }

    private static int first(int[] nums, int left, int right, int[][] dp) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = nums[left];
            return nums[left];
        }
        dp[left][right] = Math.max(nums[left] + second(nums, left + 1, right, dp), nums[right] + second(nums, left, right - 1, dp));
        return dp[left][right];
    }

    private static int second(int[] nums, int left, int right, int[][] dp) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = 0;
            return 0;
        }
        dp[left][right] = Math.min(first(nums, left + 1, right, dp), first(nums, left, right - 1, dp));
        return dp[left][right];
    }

}
