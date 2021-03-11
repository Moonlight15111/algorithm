package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/word-break/
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * <p>
 * 输入: s = "leetcode"     wordDict = ["leet", "code"]
 * 输出: true   解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * <p>
 * 输入: s = "applepenapple"  wordDict = ["apple", "pen"]
 * 输出: true   解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。 注意你可以重复使用字典中的单词。
 * <p>
 * 输入: s = "catsandog"    wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @author Moonlight
 * @date 2021/3/11 15:33
 */
public class WordBreak {

    public static void main(String[] args) {
        String a = "leetcode", b = "applepenapple", c = "catsandog", d = "aaaaaaa", e = "goalspecial";
        List<String> alist = Arrays.stream(new String[]{"leet", "code"}).collect(Collectors.toList()),
                blist = Arrays.stream(new String[]{"apple", "pen"}).collect(Collectors.toList()),
                clist = Arrays.stream(new String[]{"cats", "dog", "sand", "and", "cat"}).collect(Collectors.toList()),
                dlist = Arrays.stream(new String[]{"aaaa", "aaa"}).collect(Collectors.toList()),
                elist = Arrays.stream(new String[]{"go", "goal", "goals", "special"}).collect(Collectors.toList());
        System.out.println(wordBreak(a, alist));
        System.out.println(wordBreak(b, blist));
        System.out.println(wordBreak(c, clist));
        System.out.println(wordBreak(d, dlist));
        System.out.println(wordBreak(e, elist));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean wordBreak1231(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        boolean[] visited = new boolean[s.length() + 1];
        return backtrack(0, s, wordDict, visited);
    }

    private static boolean backtrack(int index, String s, List<String> wordDict, boolean[] visited) {
        for (String word : wordDict) {
            if (index + word.length() > s.length() || visited[index + word.length()]) {
                continue;
            }
            if (s.indexOf(word, index) == index) {
                if (index + word.length() == s.length() || backtrack(index + word.length(), s, wordDict, visited)) {
                    return true;
                }
                visited[index + word.length()] = true;
            }
        }
        return false;
    }

}
