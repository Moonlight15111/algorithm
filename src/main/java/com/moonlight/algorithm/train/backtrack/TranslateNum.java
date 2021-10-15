package com.moonlight.algorithm.train.backtrack;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 输入: 12258  输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 */
public class TranslateNum {

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        return backtrack(String.valueOf(num), 0);
    }

    private static int backtrack(String str, int i) {
        if (i >= str.length() - 1) {
            return 1;
        }
        int r = backtrack(str, i + 1);
        String sub = str.substring(i, i + 2);
        char f = sub.charAt(0), s = sub.charAt(1);
        if (f == '1' || (f == '2' && s >= '0' && s <= '5')) {
            r += backtrack(str, i + 2);
        }
        return r;
    }

}
