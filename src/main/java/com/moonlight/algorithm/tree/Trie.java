package com.moonlight.algorithm.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Trie
 * @Description: 前缀树/字典树。单个字符串中，将字符从前到后都加到一颗多叉树上面。
 * 一个字符串作为一条路，有路就复用，没有就新建，每通过一次节点节点的pass+1，结尾字符end + 1。
 * 主要用于快速搜索，最大限度的减少无所谓的对比，实际上是用空间换时间
 * @Author Moonlight
 * @Date 2020/4/25 11:30
 * @Version V1.0
 **/
public class Trie {

    public static void main(String[] args){
        Trie trie = new Trie();
        List<String> a = new ArrayList<>();
        a.add("abc");
        a.add("abc");
        a.add("acb");
        a.add("ad");
        a.add("1a2");
        a.add("1a2c");
        for (String s : a) {
            trie.insert(s);
        }
        System.out.println("search: " + trie.search("1a2"));
    }

    /**
     * 根节点
     */
    private Node root;

    public Trie(){
        this.root = new Node();
    }

    public void insert(String str){
        if (str == null || str.length() <= 0) {
            return;
        }
        Node node = root;
        node.pass++;
        char[] charArray = str.toCharArray();
        for (int path : charArray) {
            if (!node.nextMap.containsKey(path)) {
                Node new_node = new Node();
                node.nextMap.put(path, new_node);
            }
            node = node.nextMap.get(path);
            node.pass++;
        }
        node.end++;
    }

    public int search(String str){
        if (str == null || str.length() <= 0) {
            return 0;
        }
        Node node = root;
        char[] charArray = str.toCharArray();
        for (int path : charArray) {
            if (!node.nextMap.containsKey(path)) {
                return 0;
            }
            node = node.nextMap.get(path);
        }
        return node.end;
    }

    public int startWith(){
        return 0;
    }

    public boolean delete(){
        return false;
    }

    static class Node{
        private int pass = 0, end = 0;
        private Map<Integer, Node> nextMap;
        public Node () {
            nextMap = new HashMap<>();
        }
    }
}
