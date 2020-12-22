package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/add-without-plus-lcci/
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 * 输入: a = 1, b = 1
 * 输出: 2
 * @author Moonlight
 * @date 2020/12/22 17:58
 */
public class AddWithoutPlus {

    public static void main(String[] args) {
        System.out.println(add(1, 1));
        System.out.println(add(3, 4));
    }

    public static int add(int a, int b) {
        // 0 + 1 = 1，1 + 1 = 10，0 + 0 = 0  ===>  a + b  ===>  a ^ b
        // 考虑到进位 ===> 只有相同位均为 1 的时候下一位相加才会产生进位  ===> (a & b) << 1
        int x;
        while (b != 0) {
            x = a ^ b;
            b = (a & b) << 1;
            a = x;
        }
        return a;
    }

}
