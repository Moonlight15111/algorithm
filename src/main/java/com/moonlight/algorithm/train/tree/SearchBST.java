package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 给定二叉搜索树:
 *      4
 *     / \
 *    2   7
 *   / \
 *  1   3
 *
 * 和值: 2
 *
 * 返回:   2
 *        / \
 *       1   3
 *
 * @author Moonlight
 * @date 2021/5/25 13:04
 */
public class SearchBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode node = searchBST(root, 5);
        if (node == null) {
            System.out.println(" null ");
        }
        printNode(node);
    }

    private static void printNode(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + ", ");
            printNode(node.left);
            printNode(node.right);
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null && root.val != val) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == val) {
                return poll;
            }
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return null;
    }

}
