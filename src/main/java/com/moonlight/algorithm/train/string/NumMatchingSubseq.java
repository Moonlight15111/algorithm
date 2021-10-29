package com.moonlight.algorithm.train.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-matching-subsequences/
 *
 * 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
 *
 * 输入: S = "abcde"  words = ["a", "bb", "acd", "ace"]
 * 输出: 3
 * 解释: 有三个是 S 的子序列的单词: "a", "acd", "ace"。
 *
 * 解释说明:
 *   1. 所有在words和 S 里的单词都只由小写字母组成。
 *   2. S 的长度在 [1, 50000]。
 *   3. words 的长度在 [1, 5000]。
 *   4. words[i]的长度在[1, 50]。
 *
 * @author Moonlight
 */
public class NumMatchingSubseq {

    public static void main(String[] args) {
        String s = "abcde";
        String[] w = {"a", "bb", "acd", "ace"};

        System.out.println(violence(s, w) + ", " + numMatchingSubseq(s, w));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        // 类字典树, 只遍历 s 一次
        // 初始时, 根据word的首字符走不同的分支
        // 遍历时, 根据idx标记word匹配到的位置, 并根据下一个字符调整word所处的分支
        ArrayList<Node>[] arr = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = new ArrayList<>();
        }
        for (String w : words) {
            arr[w.charAt(0) - 'a'].add(new Node(w, 0));
        }
        int ans = 0;
        for (char c : s.toCharArray()) {
            ArrayList<Node> nodes = arr[c - 'a'];
            arr[c - 'a'] = new ArrayList<>();

            for (Node n : nodes) {
                n.idx++;
                if (n.idx == n.word.length()) {
                    ans++;
                } else {
                    arr[n.word.charAt(n.idx) - 'a'].add(n);
                }
            }
        }
        return ans;
    }

    private static class Node {
        String word;
        int idx;
        public Node(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }
    }

    public static int violence(String s, String[] words) {
        // 纯暴力 timeout
        Set<String> set = new HashSet<>();
        int ans = 0;
        for (String w : words) {
            if (set.contains(w)) {
                ans++;
                continue;
            }
            if (isSub(s, w)) {
                ans++;
                set.add(w);
            }
        }
        return ans;
    }

    private static boolean isSub(String s, String w) {
        int idx = 0;
        char[] chars = w.toCharArray();
        for (char c : s.toCharArray()) {
            if (idx < w.length() && chars[idx] == c) {
                idx++;
            }
        }
        return idx == w.length();
    }

}
