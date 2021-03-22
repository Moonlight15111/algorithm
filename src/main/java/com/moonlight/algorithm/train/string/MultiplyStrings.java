package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/multiply-strings/
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 输入: num1 = "2", num2 = "3"  输出: "6"
 *
 * 输入: num1 = "123", num2 = "456"  输出: "56088"
 *
 * @ClassName MultiplyStrings
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/21 14:35
 * @Version V1.0
 **/
public class MultiplyStrings {

    public static void main(String[] args) {
        // 6
        System.out.println(multiply("2", "3"));
        // 56088
        System.out.println(multiply("123", "456"));
        // 419254329864656431168468
        System.out.println(multiply("498828660196", "840477629533"));
    }

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        // 拿num2的每一位和num1进行乘，然后相加 => 模拟竖式乘法
        int ca, cur, m = num2.length(), n = num1.length();
        String res = "0";
        StringBuilder tmp;
        for (int i = m - 1; i >= 0; i--) {
            tmp = new StringBuilder();
            for (int j = 0; j < m - i - 1; j++) {
                tmp.append(0);
            }
            ca = 0;
            cur = num2.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int num = num1.charAt(j) - '0';
                int sum = cur * num + ca;
                tmp.append(sum % 10);
                ca = sum / 10;
            }
            if (ca != 0) {
                tmp.append(ca % 10);
            }
            res = add(res, tmp.reverse().toString());
        }
        return res;
    }

    private static String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int ca = 0, i = num1.length() - 1, j = num2.length() - 1, a, b, sum;
        while (i >= 0 || j >= 0 || ca != 0) {
            a = i >= 0 ? num1.charAt(i) - '0' : 0;
            b = j >= 0 ? num2.charAt(j) - '0' : 0;
            sum = a + b + ca;
            res.append(sum % 10);
            ca = sum / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

}
