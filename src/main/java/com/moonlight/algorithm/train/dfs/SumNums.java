package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 输入: n = 3  输出: 6
 *
 * 输入: n = 9  输出: 45
 *
 */
public class SumNums {

    public static void main(String[] args) {
        System.out.println(sumNums(3));
        System.out.println(sumNums(9));
    }

    public static int sumNums(int n) {
        int[] a = new int[]{0};
        try {
           return a[n];
        } catch (Exception e) {
            return n + sumNums(n - 1);
        }
//        return IntStream.range(1, n + 1).sum();
    }

}