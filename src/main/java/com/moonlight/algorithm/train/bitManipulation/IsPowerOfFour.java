package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/power-of-four/
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * 输入：n = 16
 * 输出：true
 * 输入：n = 5
 * 输出：false
 * 输入：n = 1
 * 输出：true
 * @author Moonlight
 * @date 2020/12/19 15:56
 */
public class IsPowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
        System.out.println(isPowerOfFour(1));
        System.out.println(isPowerOfFour(2));
    }

    public static boolean isPowerOfFour(int n) {
        // 如果一个数是 4 的幂次方，那它必定也是 2 的幂次方
        // 4 => 100  1 在第三位   16 => 10000（1 在第 5 位）  64 => 1000000（1 在第 7 位） 256 => 100000000（1 在第 9 位）....
        // 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1
        return n > 0 && ((n & -n) == n) && ((n & 0x55555555) == n);
    }

}
