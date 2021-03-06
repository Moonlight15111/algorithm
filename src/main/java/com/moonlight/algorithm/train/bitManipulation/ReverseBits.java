package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈颠倒给定的 32 位无符号整数的二进制位〉
 *  输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *  因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 *  原题：https://leetcode-cn.com/problems/reverse-bits
 * @author Moonlight
 * @date 2020/6/11 17:14
 */
public class ReverseBits {
    public static int reverseBits (int n) {
        int result = 0;
        // 0 -> 31, 1 -> 30 ...
        // 取下一个位置的值 计算下个位置
        for (int bitCount = 31; n != 0; n = n >>> 1, bitCount--) {
            // 取 n 的最后一位，移动到第bitCount位上
            result += (n & 1) << bitCount;
        }
        return result;
    }
}
