package com.moonlight.algorithm.train.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]  输出："apple"
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]  输出："a"
 *
 * 作者: Moonlight<bzeng@ibingli.com>
 * 创建时间: 2021-09-14 12:34
 */
public class FindLongestWord {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        a.add("ale");
        a.add("apple");
        a.add("monkey");
        a.add("plea");

        b.add("a");
        b.add("b");
        b.add("c");
        System.out.println(findLongestWord("abpcplea", a));
        System.out.println(findLongestWord("abpcplea", b));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        // 先判斷dict是否是 s 的子序列
        // 如果是 s 的子序列，则对ans进行维护，看是否需要更新ans
        String ans = "";
        for (String dict : dictionary) {
            int i = 0, j = 0;
            while (i < dict.length() && j < s.length()) {
                if (dict.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i == dict.length()) {
                if (dict.length() > ans.length() || (dict.length() == ans.length() && dict.compareTo(ans) < 0)) {
                    ans = dict;
                }
            }
        }
        return ans;
    }

}
