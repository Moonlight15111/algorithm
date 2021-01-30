package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/consecutive-characters/
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 * @author Moonlight
 * @date 2021/1/30 10:46
 */
public class StringMaxPower {

    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
        System.out.println(maxPower("hooraaaaaaaaaaay"));
        System.out.println(maxPower("tourist"));
        System.out.println(maxPower("cc"));
    }

    public static int maxPower(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 1, max = 1;
        for (int i = 1, length = s.length(); i < length; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                res = Math.max(res, max);
                max = 1;
            } else {
                max++;
            }
        }

        return Math.max(res, max);
    }

}
