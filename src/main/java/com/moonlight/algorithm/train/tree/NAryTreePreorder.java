package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * 输入：root = [1,null,3,2,4,null,5,6]  输出：[1,3,5,6,2,4]
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 * @author Moonlight
 * @date 2021/5/8 16:12
 */
public class NAryTreePreorder {

    public static void main(String[] args) {
        Node root = new Node(1);
        List<Node> rc = new ArrayList<>();
        Node n2 = new Node(2);
        Node n4 = new Node(4);

        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> n3c = new ArrayList<>();
        n3c.add(n5);
        n3c.add(n6);
        n3.children = n3c;

        rc.add(n3);
        rc.add(n2);
        rc.add(n4);

        root.children = rc;

        System.out.println(recursion(root));
        System.out.println(iteration(root));
    }

    public static List<Integer> iteration(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                Node pop = stack.pop();
                ans.add(pop.val);
                if (pop.children != null) {
                    for (int i = pop.children.size() - 1; i >= 0; i--) {
                        stack.add(pop.children.get(i));
                    }
                }
            }
        }

        return ans;
    }

    public static List<Integer> recursion(Node root) {
        List<Integer> ans = new ArrayList<>();
        pre(root, ans);
        return ans;
    }

    private static void pre(Node root, List<Integer> ans) {
        if (root != null) {
            ans.add(root.val);
            if (root.children != null) {
                for (Node c : root.children) {
                    pre(c, ans);
                }
            }
        }
    }

}
