package com.moonlight.algorithm.train.tree;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *
 * @author Moonlight
 * @date 2021/4/1 13:20
 */
public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(minDepth(root));

        TreeNode rootNode = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.right.right = new TreeNode(4);
        rootNode.right.right.right = new TreeNode(5);
        rootNode.right.right.right.right = new TreeNode(6);

        System.out.println(minDepth(rootNode));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }
}
