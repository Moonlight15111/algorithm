package com.moonlight.algorithm.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MinCommonAncestor
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/10 16:55
 * @Version V1.0
 **/
public class MinCommonAncestor {

    public static void main (String[] args) {
        Node head = Node.getTree();
        System.out.println(minCommonAncestor(head, head.left.left, head.left.right).val);

        Node node = minCommonAncestor2(head, head.left.left, head.left.right);
        System.out.println(node == null ? null : node.val);
    }


    public static Node minCommonAncestor(Node root, Node a, Node b){
        if (root == null) {
            return null;
        }

        // 用一个Map录入所有的父子关系
        Map<Node, Node> parentMap = new HashMap<>();
        parentMap.put(root, null);
        findAllParent(root, parentMap);

        // 将A结点的所有直系父节点全部压入Set
        Set<Node> parentSet = new HashSet<>();
        Node cur = a;
        parentSet.add(cur);
        while (parentMap.get(cur) != null) {
            cur = parentMap.get(cur);
            parentSet.add(cur);
        }
        // 找到最小公共祖先
        cur = b;
        while (!parentSet.contains(cur)) {
            cur = parentMap.get(cur);
        }
        return cur;
    }

    private static void findAllParent(Node root, Map<Node, Node> parentMap) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            findAllParent(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            findAllParent(root.right, parentMap);
        }
    }


    public static Node minCommonAncestor2(Node root, Node a, Node b){
        return findMinCommonAncestor(root, a, b).ancestor;
    }

    private static Info findMinCommonAncestor(Node root, Node a, Node b) {
        if (root == null) {
            return new Info (null, false, false);
        }

        Info leftInfo = findMinCommonAncestor(root.left, a, b);
        Info rightInfo = findMinCommonAncestor(root.right, a, b);

        Node ancestor = null;
        // 在左右两棵树上找AB两个结点
        boolean findA = root == a || leftInfo.findA || rightInfo.findA;
        boolean findB = root == b || leftInfo.findB || rightInfo.findB;

        if (leftInfo.ancestor != null) {
            ancestor = leftInfo.ancestor;
        }

        if (rightInfo.ancestor != null) {
            ancestor = rightInfo.ancestor;
        }

        if (ancestor == null) {
            // 如果左树和右树都没有找到交汇点，且在整棵树上有找到AB两个结点，那么说明root即为交汇点
            if (findA && findB) {
                ancestor = root;
            }
        }
        return new Info(ancestor, findA, findB);
    }

    static class Info {
        public Node ancestor;
        public boolean findA, findB;

        public Info (Node ancestor, boolean findA, boolean findB) {
            this.ancestor = ancestor;
            this.findA = findA;
            this.findB = findB;
        }
    }

}
