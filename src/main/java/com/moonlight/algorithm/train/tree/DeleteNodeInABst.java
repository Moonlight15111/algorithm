package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 *     首先找到需要删除的节点；
 *     如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * root = [5,3,6,2,4,null,7]   key = 3
 *             5
 *           / \
 *          3   6
 *        / \   \
 *      2   4   7
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *       5
 *      / \
 *     4   6
 *    /     \
 *   2       7
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *      5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 *
 * @author Moonlight
 * @date 2021/7/15 16:37
 */
public class DeleteNodeInABst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode node = deleteNode(root, 3);
        System.out.println(print(node));
    }

    private static String print(TreeNode root) {
        StringBuilder ans = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            ans.append(node.val).append(",");
        }

        return ans.toString();
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 如果目标节点大于当前节点值，则去右子树中删除
        // 如果目标节点小于当前节点值，则去左子树中删除
        // 如果目标节点就是当前节点，则分以下三种情况讨论:
        //   1. 没有左子树, 用右子树替换目标节点的位置
        //   2. 没有右子树, 用左子树替换目标节点的位置
        //   3. 左右子树都有, 将左子树嫁接到右子树的最左节点的左子树上，然后右子树替换目标节点的位置
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode rightLeft = root.right;
            while (rightLeft.left != null) {
                rightLeft = rightLeft.left;
            }
            rightLeft.left = root.left;
            root = root.right;
        }
        return root;
    }

}
