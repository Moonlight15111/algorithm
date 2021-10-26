package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 *
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 输入: "42"  输出: 42
 *
 * 输入: "   -42"  输出: -42
 *
 * 输入: "4193 with words"  输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 *
 * 输入: "words and 987"  输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 *
 * 输入: "-91283472332"  输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *
 * @author Moonlight
 */
public class StrToInt {

    public static void main(String[] args) {
        System.out.println(strToInt("42"));
        System.out.println(strToInt("   -42"));
        System.out.println(strToInt("4193 with words"));
        System.out.println(strToInt("words and 987"));
        System.out.println(strToInt("-91283472332"));
        System.out.println(strToInt("+1"));
        System.out.println(strToInt("20000000000000000000"));
        System.out.println(strToInt("  0000000000012345678"));
        System.out.println(strToInt("    0000000000000   "));
    }

    public static int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        if (isIllegal(str.charAt(0))) {
            return 0;
        }
        boolean isNeg = false;
        StringBuilder nums = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
                isNeg = str.charAt(i) == '-';
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            nums.append(str.charAt(i));
        }
        while (nums.length() > 0 && nums.charAt(0) == '0') {
            nums.deleteCharAt(0);
        }
        if (nums.length() == 0) {
            return 0;
        }
        String numStr = nums.toString();
        if (numStr.length() > 10) {
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        long ans = Long.parseLong(numStr);
        if (isNeg) {
            ans *= -1;
        }
        return ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : (ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)ans);
    }

    private static boolean isIllegal(char c) {
        return c != '+' && c != '-' && (c < '0' || c > '9');
    }

}