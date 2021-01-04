package com.moonlight.algorithm.train.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
/**
 * 规定 1 和 A 对应，2 和 B 对应，3 和 C 对应，4 和 D 对应... 26 和 Z 对应
 * 那么一个数字字符串比如“111”就可以转换为：”AAA“  "KA"  "AK"
 * 给定一个只有数字字符组成的字符串String, 返回有多少种转化结果
 * @ClassName NumberToLetter
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/2 18:35
 * @Version V1.0
 **/
public class NumberToLetter {

    public static void main(String[] args) {
        System.out.println(numToLetter("111"));
        System.out.println(numToLetter("10"));
        System.out.println(dp("111"));
        System.out.println(dp("10"));
    }

    public static int numToLetter(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    private static int process(char[] chars, int i) {
        if (i == chars.length) {
            return 1;
        }
        if (chars[i] == '0') {
            return 0;
        }
        // 假设取到了第 i 个位置，那么有两种选择，i 单独作为一个部分转化，i 和 i + 1 作为一个部分转化
        // 但是要考虑最大只能取到 26
        if (chars[i] == '1') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length) {
                res += process(chars, i + 2);
            }
            return res;
        }
        if (chars[i] == '2') {
            int res = process(chars, i + 1);
            if (i + 1 < chars.length  && chars[i + 1] >= '0' && chars[i + 1] <= 6) {
                res += process(chars, i + 2);
            }
            return res;
        }
        // 3 到 9 只能自己玩
        return process(chars, i + 1);
    }

    public static int dp(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        char[] chars = str.toCharArray();

        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                dp[i] = 0;
            } else if (chars[i] == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < len) {
                    dp[i] += dp[i + 2];
                }
            } else if (chars[i] == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < chars.length && chars[i + 1] >= '0' && chars[i + 1] <= 6) {
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

}
