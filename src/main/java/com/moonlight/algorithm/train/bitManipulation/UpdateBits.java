package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://www.lintcode.com/problem/179/
 *
 * 给出两个32位的整数N和M，以及两个二进制位的位置i和j。写一个方法来使得N中的第i到j位等于M（M会是N中从第i为开始到第j位的子串）
 *
 * 输入: N=(10000000000)2 M=(10101)2 i=2 j=6   输出: N=(10001010100)2
 *
 * 输入: N=(10000000000)2 M=(11111)2 i=2 j=6   输出: N=(10001111100)2
 *
 * 对于相同的，保持不变，对于不同的以 i 为准
 *
 * @author Moonlight
 * @date 2021/4/29 17:21
 */
public class UpdateBits {

    public static void main(String[] args) {
        // 1108
        System.out.println(updateBits(1024, 21, 2, 6));
    }

    public static int updateBits(int n, int m, int i, int j) {
        // 1. 把 n i 到 j 位都清0
        // 2. m << i 或上去
        for (int k = 0; k <= j - i; k++) {
            n &= ~(1 << k + i);
        }
        return n |= (m << i);
    }

}