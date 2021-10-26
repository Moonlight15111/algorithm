package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 *   读入字符串并丢弃无用的前导空格
 *   检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 *   读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 *   将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 *   如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 *   返回整数作为最终结果。
 *
 * 输入：s = "42"  输出：42
 * 解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
 * 第 1 步："42"（当前没有读入字符，因为没有前导空格）
 *          ^
 * 第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
 *          ^
 * 第 3 步："42"（读入 "42"）
 *            ^
 * 解析得到整数 42 。
 * 由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
 *
 * 输入：s = "   -42"  输出：-42
 * 解释：
 * 第 1 步："   -42"（读入前导空格，但忽视掉）
 *             ^
 * 第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
 *              ^
 * 第 3 步："   -42"（读入 "42"）
 *                ^
 * 解析得到整数 -42 。
 * 由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
 *
 * @author Moonlight
 */
public class MyAtoi {

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("20000000000000000000"));
        System.out.println(myAtoi("  0000000000012345678"));
        System.out.println(myAtoi("    0000000000000   "));
    }

    public static int myAtoi(String str) {
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
