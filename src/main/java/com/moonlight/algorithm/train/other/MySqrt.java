package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 输入: 4  输出: 2
 *
 * 输入: 8  输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * @ClassName MySqrt
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/24 23:05
 * @Version V1.0
 **/
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(25));
    }

    public static int mySqrt(int x) {
        // res 的 平方 <= x
        int left = 0, right = x, res = 0, mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

}
