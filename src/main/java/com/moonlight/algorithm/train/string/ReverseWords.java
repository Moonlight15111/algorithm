package com.moonlight.algorithm.train.string;

import java.util.Objects;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * @author Moonlight
 * @date 2021/1/16 16:35
 */
public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords2231("Let's take LeetCode contest"));
        System.out.println(reverseWords2212311("Let's take LeetCode contest"));
        System.out.println(reverseWordsIII("    "));
    }

    public static String reverseWordsIII(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] split = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (Objects.equals(split[i], "")) {
                continue;
            }
            res.append(split[i]).append(" ");
        }
        return "".equals(res.toString()) ? "" : res.substring(0, res.length() - 1);
    }

    public  static String reverseWords2212311(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int len = s.length(), start = 0, end = 0;
        while (end < len) {
            while (end < len && chars[end] != ' ') {
                end++;
            }
            exch(chars, start, end - 1);
            start = end + 1;
            end = start;
        }
        return new String(chars);
    }

    private static void exch(char[] chars, int start, int end) {
        char tmp;
        while (start < end) {
            tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    public  static String reverseWords2231(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] split = s.split(" ");
        StringBuilder sb, res = new StringBuilder();
        for (String str : split) {
            sb = new StringBuilder(str);
            res.append(sb.reverse()).append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack;
        for (String str : split) {
            stack = new Stack<>();
            for (Character c : str.toCharArray()) {
                stack.add(c);
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
