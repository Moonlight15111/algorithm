package com.moonlight.algorithm.train.string;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * <p>
 * 实现 strStr() 函数。给定一个 haystack 字符串和一个 needle 字符串，
 * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 输入: haystack = "hello", needle = "ll"   输出: 2
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"  输出: -1
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * @ClassName ImplementStrstr
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/14 15:51
 * @Version V1.0
 **/
public class ImplementStrstr {

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll") + ", " + strStr1231("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba") + ", " + strStr1231("aaaaa", "bba"));
    }

    public static int strStr1231(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) == needle.charAt(j) && j == needle.length() - 1) {
                    return i;
                } else if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if ("".equals(needle)) {
            return 0;
        }
        for (int i = 0, len = haystack.length(); i < len; i++) {
            while (i < len && haystack.charAt(i) != needle.charAt(0)) {
                i++;
            }
            if (i < len) {
                int length = needle.length(), j = 1;
                for (int k = i + 1; j < length && k < len && haystack.charAt(k) == needle.charAt(j); j++, k++) ;
                if (j == length) {
                    return i;
                }
            }
        }
        return -1;
    }

}
