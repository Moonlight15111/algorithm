package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/add-strings/
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * @author Moonlight
 * @date 2021/1/18 15:21
 */
public class AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("43", "57"));
        System.out.println(addStrings("23", "777"));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int ca = 0, tmp;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 ; i--, j--) {
            tmp = ca;
            tmp += i >= 0 ? num1.charAt(i) - '0' : 0;
            tmp += j >= 0 ? num2.charAt(j) - '0' : 0;
            res.append(tmp % 10);
            ca = tmp / 10;
        }
        res.append(ca == 0 ? "" : ca);
        return res.reverse().toString();
    }

}
