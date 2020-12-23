package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/insert-into-bits-lcci/
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。
 * 假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 * 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 * 输出：N = 1100(10001001100)
 *
 * 输入：N = 0, M = 31(11111), i = 0, j = 4
 * 输出：N = 31(11111)
 * @author Moonlight
 * @date 2020/12/23 11:48
 */
public class InsertBits {

    public static void main(String[] args ) {
        System.out.println(insertBits(1024, 19, 2, 6));
        System.out.println(insertBits(0, 31, 0, 4));

        System.out.println(insertBits2222(1024, 19, 2, 6));
        System.out.println(insertBits2222(0, 31, 0, 4));
    }

    public static int insertBits2222(int n, int m, int i, int j) {
        // 先把N中 i 到 j 位置的数清零
        for (int k = i; k <= j; k++) {
            if ((n & (1 << k)) != 0) {
                n -= (1 << k);
            }
        }
        // M的数左移i位
        m <<= i;
        // N | M
        return n | m;
    }

    public static int insertBits(int n, int m, int i, int j) {
        // 暴力破解
        // 把N的每一位都放到数组中，然后用M去替换数组中i - j位置的数，再循环数组把对应的数计算出来
        char[] ss = new char[32];
        for (int k = 0; k < 32; k++) {
            ss[k] = (n & (1 << k)) == 0 ? '0' : '1';
        }
        for (int k = 0, x = j - i + 1; k < x; k++) {
            ss[(i + k)] = (m & (1 << k)) == 0 ? '0' : '1';
        }

        int res = 0;
        for (int k = 0; k < 32; k++) {
            if (ss[k] == '1') {
                res |= (1 << k);
            }
        }

        return res;
    }

}
