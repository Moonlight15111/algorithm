package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串 "abcdefg" 和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @author Moonlight
 * @date 2021/1/20 11:43
 */
public class ReverseLeftWords {

    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh", 6));
        System.out.println(reverseLeftWords1231("lrloseumgh", 6));
    }

    public static String reverseLeftWords1231(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n, length = s.length(); i < length; i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

}
