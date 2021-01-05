package com.moonlight.algorithm.train.dp;

/**
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。
 * 每个值都认为是一张货币，
 * 返回组成aim的最少货币数
 * 注意：
 * 因为是求最少货币数，所以每一张货币认为是相同或者不同就不重要了
 * @ClassName MinCoins_1
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/5 22:42
 * @Version V1.0
 **/
public class MinCoins_1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 2, 1, 2, 4};
        System.out.println(minCoins(arr, 4));
    }

    public static int minCoins(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return Integer.MAX_VALUE;
        }
        if (index == arr.length) {
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i * arr[index] <= rest; i++) {
            int next = process(arr, index + 1, rest - (i * arr[index]));
            if (next != Integer.MAX_VALUE) {
                res = Math.min(res, next + i);
            }
        }
        return res;
    }

}
