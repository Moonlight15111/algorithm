package com.moonlight.algorithm.train.tree;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 输入：
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 输出：true
 *
 * 输入：
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 输出：false
 *
 */
public class IsSymmetric {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(3);
        r.left.right = new TreeNode(4);
        r.right = new TreeNode(2);
        r.right.left = new TreeNode(4);
        r.right.right = new TreeNode(3);

        System.out.println(isSymmetric(r));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        if (root.left.val != root.right.val) {
            return false;
        }
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || (left.val != right.val)) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

}