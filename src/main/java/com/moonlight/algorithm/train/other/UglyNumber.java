package com.moonlight.algorithm.train.other;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 输入：n = 6  输出：true
 * 解释：6 = 2 × 3
 *
 * 输入：n = 8  输出：true
 * 解释：8 = 2 × 2 × 2
 *
 * 输入：n = 14  输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *
 * 输入：n = 1 输出：true
 * 解释：1 通常被视为丑数。
 *
 * @ClassName UglyNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/10 0:47
 * @Version V1.0
 **/
public class UglyNumber {

    public static void main(String[] args) {
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
    }

    public static boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }

        while ((n & 1) == 0) {
            n >>= 1;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
//        int[] factors = {2, 3, 5};
//        for (int num : factors) {
//            while (n % num == 0) {
//                n /= num;
//            }
//        }

        return n == 1;
    }

}
