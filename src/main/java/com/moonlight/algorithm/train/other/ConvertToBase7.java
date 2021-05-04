package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/base-7/
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 *
 * 输入: 100  输出: "202"
 *
 * 输入: -7   输出: "-10"
 *
 * @ClassName ConvertToBase7
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/4 19:52
 * @Version V1.0
 **/
public class ConvertToBase7 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(0));
    }

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        boolean b = num < 0;
        num = Math.abs(num);
        while (num != 0) {
            ans.append(num % 7);
            num /= 7;
        }
        if (b) {
            ans.append("-");
        }
        return ans.reverse().toString();
    }

}
