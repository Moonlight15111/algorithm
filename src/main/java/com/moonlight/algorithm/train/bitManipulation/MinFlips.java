package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 * 给你三个正整数 a、b 和 c。
 * 你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算   a OR b == c  成立的最小翻转次数。
 * 「位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 * 输入：a = 2, b = 6, c = 5
 * 输出：3
 * 解释：翻转后 a = 1 , b = 4 , c = 5 使得 a OR b == c
 *
 * @author Moonlight
 * @date 2020/12/16 16:42
 */
public class MinFlips {

    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        System.out.println(minFlips(a, b, c));
    }

    public static int minFlips(int a, int b, int c) {
        // a | b = c 则 a | b 的二进制位 == c 的二进制位
        // 所以 (a | b) ^ c == a | b 和 c 二进制位不同的数
        int mask = (a | b) ^ c;
        // 按照规律，a | b 只有当在第 i 位上，a、b都为 1 ，且 c 为 0 时才需要改变两次
        int d = a & b & mask;
        return Integer.bitCount(mask) + Integer.bitCount(d);
    }

}
