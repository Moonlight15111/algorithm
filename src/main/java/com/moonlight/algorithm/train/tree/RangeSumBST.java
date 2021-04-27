package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15    输出：32
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10   输出：23
 *
 * @author Moonlight
 * @date 2021/4/27 12:44
 */
public class RangeSumBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));

    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val >= low && root.val <= high ? root.val : 0;
        }
        if (root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return 0;
    }

}