package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题; https://leetcode-cn.com/problems/convert-integer-lcci/
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * @author Moonlight
 * @date 2020/12/22 14:39
 */
public class ConvertInteger {

    public static void main(String[] args) {
        System.out.println(convertInteger(29, 15));
        System.out.println(convertInteger(1, 2));
    }

    public static int convertInteger(int a, int b) {
        int res = 0;
        // 计算 a ^ b 有多少个 1
        int x = a ^ b;
        while (x != 0) {
            res++;
            x ^= (x & (-x));
        }
        return res;
    }

}
