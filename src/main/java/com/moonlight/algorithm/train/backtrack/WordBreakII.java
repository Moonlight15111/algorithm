package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-break-ii/
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 *
 * 说明：
 *   分隔时可以重复使用字典中的单词。
 *   你可以假设字典中没有重复的单词。
 *
 * 输入: s = "catsanddog"  wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出: [ "cats and dog", "cat sand dog"]
 *
 * 输入: s = "pineapplepenapple"  wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]
 *
 * 输入: s = "catsandog"  wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: []
 *
 */
public class WordBreakII {

    public static void main(String[] args) {
        String a = "catsanddog", b = "pineapplepenapple", c = "catsandog";
        List<String> aa = new ArrayList<>(), bb = new ArrayList<>(), cc = new ArrayList<>();
        aa.add("cat");aa.add("cats");aa.add("and");aa.add("sand");aa.add("dog");

        bb.add("apple");bb.add("pen");bb.add("applepen");bb.add("pine");bb.add("pineapple");

        cc.add("cats");cc.add("dog");cc.add("sand");cc.add("and");cc.add("cat");

        System.out.println(wordBreak(a, aa));
        System.out.println(wordBreak(b, bb));
        System.out.println(wordBreak(c, cc));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>(), path = new ArrayList<>();
        backtrack(0, s, path, wordDict, ans);
        return ans;
    }

    private static void backtrack(int i, String s, List<String> path, List<String> wordDict, List<String> ans) {
        if (i == s.length()) {
            StringBuilder str = new StringBuilder();
            for (String p : path) {
                str.append(p).append(" ");
            }
            ans.add(str.deleteCharAt(str.length() - 1).toString());
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (wordDict.contains(s.substring(i, j + 1))) {
                path.add(s.substring(i, j + 1));
                backtrack(j + 1, s, path, wordDict, ans);
                path.remove(path.size() - 1);
            }
        }
    }


}
