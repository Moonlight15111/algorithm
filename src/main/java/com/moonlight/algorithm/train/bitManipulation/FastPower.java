package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://www.lintcode.com/problem/140/
 *
 * 计算a ^ n % b，其中a，b和n都是32位的非负整数。
 *
 * 输入: a = 2, n = 31, b = 3  输出: 2 的 31 次方 % 3 = 2
 *
 * @author Moonlight
 * @date 2021/4/29 16:39
 */
public class FastPower {

    public static void main(String[] args) {
        // 2
        System.out.println(fastPower(2, 3, 31));
        // 5
        System.out.println(fastPower(3, 7, 5));
    }

    public static int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }
        long half = fastPower(a, b, n >>> 1);
        half = (half * half) % b;
        if ((n & 1) == 1) {
            half = (a * half) % b;
        }
        return (int) half;
    }

}
