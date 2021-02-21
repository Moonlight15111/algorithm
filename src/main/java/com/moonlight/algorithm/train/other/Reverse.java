package com.moonlight.algorithm.train.other;

/**
 * 原题: https://leetcode-cn.com/problems/reverse-integer/
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 输入：x = 123  输出：321    输入：x = -123   输出：-321    输入：x = 120  输出：21
 *
 * @ClassName Reverse
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/21 17:53
 * @Version V1.0
 **/
public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        if (x == 0 || (x > 0 && x < 10)) {
            return x;
        }
        long res = 0;
        int tmp;
        while (x != 0) {
            tmp = x % 10;
            x /= 10;
            res = res * 10 + tmp;
        }
        return (int)res == res ? (int)res : 0;
    }

}
