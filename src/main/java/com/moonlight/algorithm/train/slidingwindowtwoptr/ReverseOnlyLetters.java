package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/reverse-only-letters/
 *
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 *
 * 输入："ab-cd"   输出："dc-ba"
 *
 * 输入："a-bC-dEf-ghIj"   输出："j-Ih-gfE-dCba"
 *
 * 输入："Test1ng-Leet=code-Q!"   输出："Qedo1ct-eeLg=ntse-T!"
 *
 * @ClassName ReverseOnlyLetters
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/5 11:39
 * @Version V1.0
 **/
public class ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public static String reverseOnlyLetters(String s) {
        int l = 0, len = s.length(), r = len - 1;
        char[] chars = s.toCharArray();
        String words = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (l < r && l < len) {
            while (l < len && words.indexOf(chars[l]) == -1) {
                l++;
            }
            while (r > 0 && words.indexOf(chars[r]) == -1) {
                r--;
            }
            if (l < r) {
                swap(l, r, chars);
                l++;
                r--;
            }
        }
        return new String(chars);
    }

    public static void swap(int l, int r, char[] chars) {
        char t = chars[l];
        chars[l] = chars[r];
        chars[r] = t;
    }

}
