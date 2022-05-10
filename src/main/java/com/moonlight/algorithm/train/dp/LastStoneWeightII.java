package com.moonlight.algorithm.train.dp;

/**
 * https://leetcode.cn/problems/last-stone-weight-ii/
 *
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出 任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *    如果 x == y，那么两块石头都会被完全粉碎；
 *    如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * 输入：stones = [2,7,4,1,8,1]  输出：1
 * 解释：
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 *
 * 输入：stones = [31,26,33,21,40]  输出：5
 *
 * @author Moonlight
 */
public class LastStoneWeightII {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(lastStoneWeight(new int[]{31, 26, 33, 21, 40}));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        // 可以理解成一堆石头分成两堆，求怎么分，这两堆石头的差值才最小 也就是说每堆石头的重量都要接近或等于 sum / 2
        // 然后套模板 - https://leetcode.cn/problems/last-stone-weight-ii/solution/yi-pian-wen-zhang-chi-tou-bei-bao-wen-ti-5lfv/
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int s : stones) {
            for (int i = target; i >= s ; i--) {
                dp[i] = Math.max(dp[i], dp[i - s] + s);
            }
        }
        return sum - 2 * dp[target];
    }

}