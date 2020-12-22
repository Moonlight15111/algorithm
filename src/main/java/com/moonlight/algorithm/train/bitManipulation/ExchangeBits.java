package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/exchange-lcci/
 * 配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。
 * 输入：num = 2（或者0b10）
 * 输出 1 (或者 0b01)
 * 输入：num = 3
 * 输出：3
 * @author Moonlight
 * @date 2020/12/22 17:34
 */
public class ExchangeBits {

    public static void main(String[] args) {
        System.out.println(exchangeBits(2));
        System.out.println(exchangeBits(3));
        System.out.println(exchangeBits(4));
        System.out.println(exchangeBits(571603718));
    }

    public static int exchangeBits(int num) {
        return ((num & 0xAAAAAAAA) >> 1) | ((num & 0x55555555) << 1);
    }

}
