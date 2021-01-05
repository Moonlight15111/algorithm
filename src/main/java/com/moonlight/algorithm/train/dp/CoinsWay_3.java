package com.moonlight.algorithm.train.dp;

/**
 * arr是货币数组，其中的值都是正数。再给定一个正数aim。
 * 每个值都认为是一张货币，
 * 认为值相同的货币没有任何不同，
 * 返回组成aim的方法数
 * 例如：arr = {1, 2, 1, 1, 2, 1, 2}，aim = 4
 * 方法：1+1+1+1、1+1+2、2+2
 * 一共就3种方法，所以返回3
 * @ClassName CoinsWay_3
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/5 22:22
 * @Version V1.0
 **/
public class CoinsWay_3 {

    public static void main(String[] args) {

    }

    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    private static int process(int[] arr, int index, int rest) {
        if (rest < 0) {
            return 0;
        }
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        // 关键在于如何消除重复解，暂时写不出来
        return 0;
    }

}
