package com.moonlight.algorithm.train.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * 实现词典类 WordDictionary ：
 *   1. WordDictionary() 初始化词典对象
 *   2. void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 *   3. bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。
 *      word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * 输入： ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 *       [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出： [null,null,null,null,false,true,true,true]
 *
 * 解释： WordDictionary wordDictionary = new WordDictionary();
 *       wordDictionary.addWord("bad");
 *       wordDictionary.addWord("dad");
 *       wordDictionary.addWord("mad");
 *       wordDictionary.search("pad"); // return False
 *       wordDictionary.search("bad"); // return True
 *       wordDictionary.search(".ad"); // return True
 *       wordDictionary.search("b.."); // return True
 *
 */
public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        // False
        System.out.println(wordDictionary.search("pad"));
        // True
        System.out.println(wordDictionary.search("bad"));
        // True
        System.out.println(wordDictionary.search(".ad"));
        // True
        System.out.println(wordDictionary.search("b.."));
    }

    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = root, node;
        cur.p++;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!cur.m.containsKey(c)) {
                node = new Node();
                cur.m.put(c, node);
            }
            cur = cur.m.get(c);
            cur.p++;
        }
        cur.e++;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node node) {
        if (idx == word.length()) {
            return node.e > 0;
        }
        char ch = word.charAt(idx);
        if (ch == '.') {
            char c = 'a';
            for (int i = 0; i < 26; i++) {
                c += i;
                if (node.m.get(c) != null && dfs(word, idx + 1, node.m.get(c))) {
                    return true;
                }
                c = 'a';
            }
            return false;
        }
        return node.m.containsKey(ch) && dfs(word, idx + 1, node.m.get(ch));
    }

    private static class Node {
        int p;
        int e;
        Map<Character, Node> m;

        public Node() {
            p = 0;
            e = 0;
            m = new HashMap<>();
        }
    }

}
