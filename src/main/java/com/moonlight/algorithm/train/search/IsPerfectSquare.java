package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/valid-perfect-square/
 *
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 *
 * 输入：num = 16  输出：true
 *
 * 输入：num = 14  输出：false
 *
 * @author Moonlight
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(256));
        System.out.println(isPerfectSquare(2147483647));
    }

    public static boolean isPerfectSquare(int num) {
        int l = 0, r = num, m;
        long s;
        while (l <= r) {
            m = ((r - l) >> 1) + l;
            s = (long)m * m;
            if (s > num) {
                r = m -  1;
            } else if (s < num) {
                l = m + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
