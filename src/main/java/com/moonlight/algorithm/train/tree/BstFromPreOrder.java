package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , 
 * Node.right 的任何后代的值 严格大于 Node.val。
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 *
 * 输入：preorder = [8,5,1,7,10,12]  输出：[8,5,10,1,7,null,12]
 *
 * 输入: preorder = [1,3]  输出: [1,null,3]
 *
 * @author Moonlight
 */
public class BstFromPreOrder {

    public static void main(String[] args) {
        TreeNode node = bstFromPreOrder(new int[]{8, 5, 1, 7, 10, 12});
        StringBuilder sb = new StringBuilder();
        p(sb, node);
        System.out.println(sb.toString());
    }

    private static void p(StringBuilder sb, TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            node = q.poll();
            sb.append(node.val).append(",");
            if (node.left == null) {
                sb.append("null,");
            } else {
                q.add(node.left);
            }
            if (node.right == null) {
                sb.append("null,");
            } else {
                q.add(node.right);
            }
        }
    }


    public static TreeNode bstFromPreOrder(int[] preOrder) {
        TreeNode root = new TreeNode(preOrder[0]);
        for (int i = 1; i < preOrder.length; i++) {
            build(root, preOrder[i]);
        }
        return root;
    }

    private static void build(TreeNode root, int val) {
        TreeNode node = new TreeNode(val), tmp = root, parent = null;
        while (tmp != null) {
            parent = tmp;
            if (tmp.val > val) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (parent != null) {
            if (parent.val > val) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

}
