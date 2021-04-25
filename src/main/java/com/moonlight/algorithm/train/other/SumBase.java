package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给你一个整数 n（10 进制）和一个基数 k ，请你将 n 从 10 进制表示转换为 k 进制表示，计算并返回转换后各位数字的 总和 。
 * 转换后，各位数字应当视作是 10 进制数字，且它们的总和也应当按 10 进制表示返回。
 *
 * 输入：n = 34, k = 6   输出：9
 * 解释：34 (10 进制) 在 6 进制下表示为 54 。5 + 4 = 9 。
 *
 * 输入：n = 10, k = 10   输出：1
 * 解释：n 本身就是 10 进制。 1 + 0 = 1 。
 *
 * @author Moonlight
 * @date 2021/4/25 12:40
 */
public class SumBase {

    public static void main(String[] args) {
        // 9
        System.out.println(sumBase(34, 6));
        // 1
        System.out.println(sumBase(10, 10));
        // 3
        System.out.println(sumBase(42, 2));
    }

    public static int sumBase(int n, int k) {
        if (k == 10) {
            return getSum(n);
        }
        int x = 0;

        while (n != 0) {
            x = x * 10 + n % k;
            n /= k;
        }

        return getSum(x);
    }

    public static int getSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

}
