package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode.cn/problems/percentage-of-letter-in-string/
 *
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 *
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * letter 是一个小写英文字母
 *
 * 输入：s = "foobar", letter = "o"  输出：33
 * 解释：
 * 等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。

 * 输入：s = "jjjj", letter = "k"  输出：0
 * 解释：
 * 等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。
 *
 * @author Moonlight
 */
public class PercentageLetter {

    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
        System.out.println(percentageLetter("jjjj", 'k'));
    }

    public static int percentageLetter(String s, char letter) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        return (int)(((double)cnt[letter - 'a'] / s.length()) * 100);
    }

}