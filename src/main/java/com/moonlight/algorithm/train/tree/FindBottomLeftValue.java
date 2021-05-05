package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 *
 * 输出:  1
 *
 * 输入:
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:  7
 *
 * @ClassName FindBottomLeftValue
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/5 19:34
 * @Version V1.0
 **/
public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        TreeNode node = new TreeNode();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return node.val;
    }

}