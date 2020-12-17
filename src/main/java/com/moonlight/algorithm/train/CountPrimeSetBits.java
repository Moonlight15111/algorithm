package com.moonlight.algorithm.train;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 * 注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。
 * 输入: L = 6, R = 10
 * 输出: 4
 * 解释:
 * 6 -> 110 (2 个计算置位，2 是质数)
 * 7 -> 111 (3 个计算置位，3 是质数)
 * 9 -> 1001 (2 个计算置位，2 是质数)
 * 10-> 1010 (2 个计算置位，2 是质数)
 * L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * R - L 的最大值为 10000。
 *
 * @author Moonlight
 * @date 2020/12/17 15:24
 */
public class CountPrimeSetBits {

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
        System.out.println(countPrimeSetBits222(6, 10));
        System.out.println(countPrimeSetBits222(10, 15));
    }

    public static int countPrimeSetBits222(int L, int R) {
        if (L > R) {
            return 0;
        }
        int res = 0;
        for (int i = L; i <= R; i++) {
            res += ((665772 >> Integer.bitCount(i)) & 1);
        }
        return res;
    }

    public static int countPrimeSetBits(int L, int R) {
        if (L > R) {
            return 0;
        }
        int res = 0;
        // 在这些位上有1的为质数
        int[] primes = {0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        for (int i = L; i <= R; i++) {
            res += primes[Integer.bitCount(i)];
        }
        return res;
    }
}
