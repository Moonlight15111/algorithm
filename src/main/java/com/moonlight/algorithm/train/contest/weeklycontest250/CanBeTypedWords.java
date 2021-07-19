package com.moonlight.algorithm.train.contest.weeklycontest250;

import java.util.Objects;

/**
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；
 * 另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，
 * 返回你可以使用此键盘完全输入的 text 中单词的数目。
 *
 * 输入：text = "hello world", brokenLetters = "ad"
 * 输出：1
 * 解释：无法输入 "world" ，因为字母键 'd' 已损坏。
 *
 * 输入：text = "leet code", brokenLetters = "lt"
 * 输出：1
 * 解释：无法输入 "leet" ，因为字母键 'l' 和 't' 已损坏。
 *
 * 输入：text = "leet code", brokenLetters = "e"
 * 输出：0
 * 解释：无法输入任何单词，因为字母键 'e' 已损坏。
 *
 * @ClassName CanBeTypedWords
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/7/18 10:36
 * @Version V1.0
 **/
public class CanBeTypedWords {

    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad"));
        System.out.println(canBeTypedWords("leet code", "lt"));
        System.out.println(canBeTypedWords("leet code", "e"));
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        int[] help = new int[26];
        for (char c : brokenLetters.toCharArray()) {
            help[c - 'a']++;
        }
        String[] s = text.split(" ");
        for (String val : s) {
            for (char c : val.toCharArray()) {
                if (help[c - 'a'] != 0) {
                    ans++;
                    break;
                }
            }
        }
        return s.length - ans;
    }

}
