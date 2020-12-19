package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/sum-of-two-integers/
 * 输入: a = 1, b = 2
 * 输出: 3
 * 输入: a = -2, b = 3
 * 输出: 1
 * @author Moonlight
 * @date 2020/12/19 16:41
 */
public class GetSum {

    public static void main(String[] args) {
        System.out.println(getSum(1, 2));
        System.out.println(getSum(-2, 3));
    }

    public static int getSum(int a, int b) {
        int temp;
        while (b != 0) {
            // 低位 = a^b  进位 = a & b
            temp = a ^ b;
            b = ((a & b) << 1);
            a = temp;
        }
        return a;
    }

}
