package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]   输出：[[1],[3,2,4],[5,6]]
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * @author Moonlight
 * @date 2021/7/15 11:18
 */
public class NAryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> rootChild = new ArrayList<>(), nodeChild = new ArrayList<>();

        Node node = new Node(3);

        rootChild.add(node);
        rootChild.add(new Node(2));
        rootChild.add(new Node(4));
        root.children = rootChild;

        nodeChild.add(new Node(5));
        nodeChild.add(new Node(6));
        node.children = nodeChild;

        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.children == null || root.children.size() == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list;
        Node node;
        int size;
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                list.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
            }
            ans.add(list);
        }
        return ans;
    }

}
