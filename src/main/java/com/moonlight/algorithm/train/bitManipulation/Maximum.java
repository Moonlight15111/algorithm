package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-lcci/submissions/
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 * @author Moonlight
 * @date 2020/12/21 17:10
 */
public class Maximum {

    public static void main(String[] args) {
        System.out.println(maximum(1, 2));
        System.out.println(maximum(2147483647, -2147483648));
        System.out.println(maximum(-7, -1004522707));
    }

    public static int maximum(int a, int b) {
        long i = (long)a - b;
        return i > 0 ? a : (i == 0 ? a : b);
    }

}
