package com.moonlight.algorithm.train.tree;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 *
 * 输入：root = [1,2,3,4,5,6]   输出：6
 *
 * 输入：root = []  输出：0
 *
 * 输入：root = [1]  输出：1
 *
 * @author Moonlight
 * @date 2021/7/7 16:27
 */
public class CountNodes {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

}