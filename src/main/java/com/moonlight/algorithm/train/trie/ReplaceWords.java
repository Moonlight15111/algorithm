package com.moonlight.algorithm.train.trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/replace-words/
 *
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。
 * 例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。
 * 如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * 你需要输出替换之后的句子。
 *
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 *
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 *
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 *
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 *
 * @author Moonlight
 */
public class ReplaceWords {

    public static void main(String[] args) {
        String[] a = {"cat", "bat", "rat"},
                 b = {"a", "b", "c"},
                 c = {"a", "aa", "aaa", "aaaa"},
                 d = {"catt", "cat", "bat", "rat"},
                 e = {"ac", "ab"};
        System.out.println(replaceWords(Arrays.asList(a), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(Arrays.asList(b), "aadsfasf absbs bbab cadsfafs"));
        System.out.println(replaceWords(Arrays.asList(c), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
        System.out.println(replaceWords(Arrays.asList(d), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(Arrays.asList(e), "it is abnormal that this solution is accepted"));
    }

    static Node root;

    public static String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();

        for (String s : dictionary) {
            build(s);
        }

        StringBuilder ans = new StringBuilder();

        Node cur;
        for (String s : sentence.split(" ")) {
            cur = root;
            for (char c : s.toCharArray()) {
                if (!cur.n.containsKey(c) || cur.w != null) {
                    break;
                }
                cur = cur.n.get(c);
            }
            ans.append(cur.w != null ? cur.w : s).append(" ");
        }
        return ans.deleteCharAt(ans.length() - 1).toString();
    }

    private static void build(String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            if (!cur.n.containsKey(c)) {
                cur.n.put(c, new Node());
            }
            cur = cur.n.get(c);
            cur.p++;
        }
        cur.e++;
        cur.w = s;
    }

    private static class Node {
        String w;
        int p;
        int e;
        Map<Character, Node> n;

        public Node() {
            this.w = null;
            this.p = 0;
            this.e = 0;
            this.n = new HashMap<>();
        }
    }

}