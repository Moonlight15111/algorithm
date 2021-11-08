package com.moonlight.algorithm.train.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/search-suggestions-system/
 *
 * 给你一个产品数组 products 和一个字符串 searchWord ，products  数组中每个产品都是一个字符串。
 * 请你设计一个推荐系统，在依次输入单词 searchWord 的每一个字母后，
 * 推荐 products 数组中前缀与 searchWord 相同的最多三个产品。如果前缀相同的可推荐产品超过三个，请按字典序返回最小的三个。
 * 请你以二维列表的形式，返回在输入 searchWord 每个字母后相应的推荐产品的列表。
 *
 * 输入：products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * 输出：[ ["mobile","moneypot","monitor"],
 *        ["mobile","moneypot","monitor"],
 *        ["mouse","mousepad"],
 *        ["mouse","mousepad"],
 *        ["mouse","mousepad"]
 *      ]
 * 解释：按字典序排序后的产品列表是 ["mobile","moneypot","monitor","mouse","mousepad"]
 * 输入 m 和 mo，由于所有产品的前缀都相同，所以系统返回字典序最小的三个产品 ["mobile","moneypot","monitor"]
 * 输入 mou， mous 和 mouse 后系统都返回 ["mouse","mousepad"]
 *
 * 输入：products = ["havana"], searchWord = "havana"
 * 输出：[["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 *
 * 输入：products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * 输出：[["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 *
 * 输入：products = ["havana"], searchWord = "tatiana"
 * 输出：[[],[],[],[],[],[],[]]
 *
 * @author Moonlight
 */
public class SuggestedProducts {

    public static void main(String[] args) {
        String[] a = {"mobile", "mouse", "moneypot", "monitor", "mousepad"},
                 b = {"havana"},
                 c = {"bags", "baggage", "banner", "box", "cloths"},
                 d = {"havana"};

        List<List<String>> lists = suggestedProducts(a, "mouse");
        for (List<String> list : lists) {
            System.out.print(list + ", ");
        }
        System.out.println("\r\n");

        lists = suggestedProducts(b, "havana");
        for (List<String> list : lists) {
            System.out.print(list + ", ");
        }
        System.out.println("\r\n");

        lists = suggestedProducts(c, "bags");
        for (List<String> list : lists) {
            System.out.print(list + ", ");
        }
        System.out.println("\r\n");

        lists = suggestedProducts(d, "tatiana");
        for (List<String> list : lists) {
            System.out.print(list + ", ");
        }
    }

    static Node root;

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Node();
        for (String s : products) {
            build(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            ans.add(search(searchWord.substring(0, i)));
        }
        return ans;
    }

    private static List<String> search(String words) {
        List<String> res = new ArrayList<>();

        Node cur = root;
        for (char c : words.toCharArray()) {
            if (!cur.n.containsKey(c)) {
                return res;
            }
            cur = cur.n.get(c);
        }

        StringBuilder sb = new StringBuilder(words);
        searchKeyWords(sb, cur, res);
        res.sort(String::compareTo);

        return res.size() > 3 ? res.subList(0, 3) : res;
    }

    private static void searchKeyWords(StringBuilder sb, Node cur, List<String> res) {
        if (cur.e > 0) {
            res.add(sb.toString());
        }
        for (char key : cur.n.keySet()) {
            sb.append(key);
            searchKeyWords(sb, cur.n.get(key), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void build(String s) {
        Node cur = root, node;
        for (char c : s.toCharArray()) {
            if (!cur.n.containsKey(c)) {
                node = new Node();
                cur.n.put(c, node);
            }
            cur = cur.n.get(c);
            cur.p++;
        }
        cur.e++;
    }

    private static class Node {
        int p;
        int e;
        Map<Character, Node> n;

        public Node() {
            this.p = 0;
            this.e = 0;
            this.n = new HashMap<>();
        }
    }

}
