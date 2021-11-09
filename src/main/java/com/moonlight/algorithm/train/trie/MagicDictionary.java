package com.moonlight.algorithm.train.trie;

/**
 * https://leetcode-cn.com/problems/implement-magic-dictionary/
 * <p>
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。
 * 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，
 * 使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 * <p>
 * 输入
 * ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *
 * @author Moonlight
 */
public class MagicDictionary {

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        // 返回 False
        System.out.println(magicDictionary.search("hello"));
        // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        System.out.println(magicDictionary.search("hhllo"));
        // 返回 False
        System.out.println(magicDictionary.search("hell"));
        // 返回 False
        System.out.println(magicDictionary.search("leetcoded"));
    }

    Node root;

    public MagicDictionary() {
        this.root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                if (cur.c[c - 'a'] == null) {
                    cur.c[c - 'a'] = new Node();
                }
                cur = cur.c[c - 'a'];
            }
            cur.isLeaf = true;
        }
    }

    public boolean search(String searchWord) {
        return search(searchWord, 0, root, 1);
    }

    private boolean search(String searchWord, int idx, Node node, int replace) {
        if (node == null) {
            return false;
        }
        if (idx == searchWord.length()) {
            return node.isLeaf && replace == 0;
        }
        int nodeIdx = searchWord.charAt(idx) - 'a';
        if (node.c[nodeIdx] != null && search(searchWord, idx + 1, node.c[nodeIdx], replace)) {
            return true;
        }
        if (replace > 0) {
            for (int i = 0; i < 26; i++) {
                if (node.c[i] == null || i == nodeIdx) {
                    continue;
                }
                if (search(searchWord, idx + 1, node.c[i], replace - 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class Node {
        boolean isLeaf;
        Node[] c;

        public Node() {
            this.isLeaf = false;
            this.c = new Node[26];
        }
    }

}
