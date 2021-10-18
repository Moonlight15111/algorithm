package com.moonlight.algorithm.train.recursion;

/**
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题
 *
 * 输入：x = 2.00000, n = 10  输出：1024.00000
 *
 * 输入：x = 2.00000, n = -2  输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.0, -2));
    }

    public static double myPow(double x, int n) {
        double p = pow(x, n);
        if (n < 0) {
            return 1 / p;
        }
        return p;
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double p = pow(x, n / 2);

        if (n % 2 == 0) {
            return p * p;
        }
        return p * p * x;
    }

}
