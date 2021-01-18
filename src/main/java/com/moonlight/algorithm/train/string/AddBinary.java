package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/add-binary/
 *
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 输入: a = "11", b = "1"   输出: "100"
 *
 * 输入: a = "1010", b = "1011"   输出: "10101"
 *
 * @author Moonlight
 * @date 2021/1/18 12:19
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("1111", "1111"));
        System.out.println(addBinary("1010", "1011"));

        System.out.println(addBinary1231("1111", "1111"));
        System.out.println(addBinary1231("1010", "1011"));
    }

    public static String addBinary1231(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ca = 0, tmp;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 ; i--, j--) {
            tmp = ca;
            tmp += i >= 0 ? a.charAt(i) - '0' : 0;
            tmp += j >= 0 ? b.charAt(j) - '0' : 0;
            res.append(tmp % 2);
            ca = tmp / 2;
        }
        res.append(ca == 1 ? '1' : "");
        return res.reverse().toString();
    }

    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 ; i--, j--) {
            char aChar = i >= 0 ? a.charAt(i) : '0';
            char bChar = j >= 0 ? b.charAt(j) : '0';
            if (aChar == '1' && bChar == '1') {
                if (ca == 1) {
                    res.append('1');
                } else {
                    res.append('0');
                }
                ca = 1;
            } else if (aChar == '1' || bChar == '1') {
                if (ca == 1) {
                    res.append('0');
                    ca = 1;
                } else {
                    res.append('1');
                    ca = 0;
                }
            } else {
                if (ca == 1) {
                    res.append('1');
                } else {
                    res.append('0');
                }
                ca = 0;
            }
        }
        res.append(ca == 1 ? '1' : "");
        return res.reverse().toString();
    }

}
