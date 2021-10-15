package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 我们希望将二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 *
 *
 */
public class TreeToDoublyList {

    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }
        List<Node> list = new ArrayList<>();
        mid(root, list);

        Node c = list.get(0), n;
        for (int i = 1; i < list.size(); i++) {
            n = list.get(i);
            c.right = n;
            n.left = c;
            c = n;
        }
        c = list.get(0);
        n = list.get(list.size() - 1);
        c.left = n;
        n.right = c;
        return c;
    }

    private static void mid(Node root, List<Node> list) {
        if (root != null) {
            mid(root.left, list);
            list.add(root);
            mid(root.right, list);
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


}
