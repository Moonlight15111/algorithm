package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/compress-string-lcci/
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 *
 *  输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * @author Moonlight
 * @date 2021/1/27 16:00
 */
public class CompressString {

    public static void main(String[] args) {
        System.out.println(compressString111("aabcccccaaa"));
        System.out.println(compressString111("abbccd"));

        System.out.println(compressString222("aabcccccaaa"));
        System.out.println(compressString222("abbccd"));
    }

    public static String compressString222(String S) {
        if (S == null || S.length() == 0 || S.length() <= 2) {
            return S;
        }
        StringBuilder res = new StringBuilder();
        char[] chars = S.toCharArray();
        int cur = 1, prev = 0;
        while (cur < S.length()) {
            if (chars[cur] == chars[prev]) {
                cur++;
            } else {
                res.append(chars[prev]).append(cur - prev);
                prev = cur;
            }
        }
        res.append(chars[prev]).append(cur - prev);
        return res.length() >= S.length() ? S : res.toString();
    }

    public static String compressString111(String S) {
        if (S == null || S.length() == 0 || S.length() <= 2) {
            return S;
        }
        int[] arr = new int[58];
        for (char c : S.toCharArray()) {
            arr[c - 'A']++;
        }
        StringBuilder res = new StringBuilder();
        char c;
        for (int i = 0, length = arr.length; i < length; i++) {
            if (arr[i] > 0) {
                c = (char)(i + 'A');
                res.append(c).append(arr[i]);
            }
        }
        return res.length() >= S.length() ? S : res.toString();
    }

}
