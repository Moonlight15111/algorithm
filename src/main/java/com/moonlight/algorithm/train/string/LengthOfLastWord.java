package com.moonlight.algorithm.train.string;

/**
 * 原题：https://leetcode-cn.com/problems/length-of-last-word/
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * @ClassName LengthOfLastWord
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/17 18:13
 * @Version V1.0
 **/
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = chars.length - 1; i >= 0 ; i--) {
            if (chars[i] != ' ') {
                res++;
            }
            if (chars[i] == ' ' && res != 0) {
                break;
            }
        }
        return res;
    }

}
