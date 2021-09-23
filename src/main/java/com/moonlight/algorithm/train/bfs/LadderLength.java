package com.moonlight.algorithm.train.bfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 *     序列中第一个单词是 beginWord 。
 *     序列中最后一个单词是 endWord 。
 *     每次转换只能改变一个字母。
 *     转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord、endWord 和 wordList[i] 由小写英文字母组成
 * beginWord != endWord
 * wordList 中的所有字符串 互不相同
 *
 */
public class LadderLength {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (String s : wordList) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    if (!convert(poll, s)) {
                        continue;
                    }
                    if (s.equals(endWord)) {
                        return cnt + 1;
                    }
                    visited.add(s);
                    queue.add(s);
                }
            }
        }
        return 0;
    }

    private static boolean convert(String poll, String s) {
        if (poll.length() != s.length()) {
            return false;
        }
        int dif = 0;
        for (int i = 0; i < poll.length(); i++) {
            if (poll.charAt(i) != s.charAt(i)) {
                dif++;
                if (dif > 1) {
                    return false;
                }
            }
        }
        return true;
    }


}
