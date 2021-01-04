package com.moonlight.algorithm.train.recursion;

/**
 * 在从左到右上尝试的模型
 * 给定两个长度都为N的数组weights和values，weights[i]和values[i]分别代表i号物品的重量和价值
 * 给定一个正数bag，代表一个载重bag的袋子，你装的物品不能超过这个重量
 * 返回你能装下最多的价值是多少
 * @ClassName MaxValues
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/3 14:10
 * @Version V1.0
 **/
public class MaxValues {

    public static void main(String[] args) {
        int[] weight = {1, 2, 5, 2, 7};
        int[] values = {2, 4, 1, 3, 8};
        System.out.println(getMaxValue(weight, values, 9));
        System.out.println(dp(weight, values, 9));
    }

    public static int getMaxValue(int[] weights, int[] values, int bag) {
        return getMaxValue(weights, values, 0, 0, bag);
    }

    public static int getMaxValue(int[] weights, int[] values, int index, int existWeight, int bag) {
        if (existWeight > bag) {
            return -1;
        }
        if (index == weights.length) {
            return 0;
        }
        // 两个方向，要某个货物，不要某个货物
        int notSkip = getMaxValue(weights, values, index + 1, weights[index] + existWeight, bag);
        int skip = getMaxValue(weights, values, index + 1, existWeight, bag);
        if (notSkip != -1) {
            notSkip += values[index];
        }
        return Math.max(notSkip, skip);
    }

    public static int dp(int[] weights, int[] values, int bag) {
        int len = weights.length;
        int[][] dp = new int[len + 1][bag + 1];
        for (int i = len - 1; i >= 0 ; i--) {
            for (int j = 0; j <= bag; j++) {
                int skip = dp[i + 1][j];
                int notSkip = -1;
                if (j - weights[i] >= 0) {
                    notSkip = dp[i + 1][j - weights[i]] + values[i];
                }
                dp[i][j] = Math.max(skip, notSkip);
            }
        }
        return dp[0][bag];
    }

}
