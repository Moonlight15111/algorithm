package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/add-digits/
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * 输入: 38  输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * @author Moonlight
 * @date 2021/1/18 15:07
 */
public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits1231(38));
    }

    public static int addDigits1231(int num) {
        if (num < 10) {
            return num;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }

    public static int addDigits(int num) {
        int tmp;
        while (num >= 10) {
            tmp = 0;
            while (num != 0) {
                tmp += num % 10;
                num /= 10;
            }
            num = tmp;
        }
        return num;
    }

}
