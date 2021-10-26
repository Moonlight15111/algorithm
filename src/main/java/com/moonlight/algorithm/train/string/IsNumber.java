package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 数值（按顺序）可以分成以下几个部分：
 *   若干空格
 *   一个 小数 或者 整数
 *  （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 *   若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *   可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 *   至少一位数字，后面跟着一个点 '.'
 *   至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 *   一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 *  （可选）一个符号字符（'+' 或 '-'）
 *   至少一位数字
 * 部分数值列举如下：
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 *
 * 输入：s = "0"  输出：true
 *
 * 输入：s = "e"  输出：false
 *
 * 输入：s = "."  输出：false
 *
 * 输入：s = "    .1  "  输出：true
 *
 * @author Moonlight
 */
public class IsNumber {

    public static void main(String[] args) {
        System.out.println(isNumber("0"));
        System.out.println(isNumber("e"));
        System.out.println(isNumber("."));
        System.out.println(isNumber("     .1  "));
        System.out.println(isNumber("12e+5.4"));
        System.out.println(isNumber("-1E-16"));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int idx = 0, len = chars.length;
        boolean hasNum = false, hasE = false, hasDot = false, hasSign = false;
        while (idx < len) {
            if (chars[idx] >= '0' && chars[idx] <= '9') {
                hasNum = true;
            } else if (chars[idx] == 'e' || chars[idx] == 'E') {
                if (!hasNum || hasE) {
                    return false;
                }
                hasE = true;
                hasNum = false;
                hasDot = false;
                hasSign = false;
            } else if (chars[idx] == '+' || chars[idx] == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (chars[idx] == '.') {
                if(hasDot || hasE){
                    return false;
                }
                hasDot = true;
            } else {
                return false;
            }
            idx++;
        }
        return hasNum;
    }

}
