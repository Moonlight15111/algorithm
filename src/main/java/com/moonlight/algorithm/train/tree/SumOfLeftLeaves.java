package com.moonlight.algorithm.train.tree;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 输入:     3
 *         / \
 *        9  20
 *          /  \
 *        15   7
 * 输出: 24 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @ClassName SumOfLeftLeaves
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/17 13:35
 * @Version V1.0
 **/
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        System.out.println(sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves(root2));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return sum(root.left, true, root.left != null && root.left.left == null && root.left.right == null)
                + sum(root.right, false, root.right != null && root.right.left == null && root.right.right == null);
    }

    public static int sum(TreeNode root, boolean isLeft, boolean isLeaves) {
        if (root == null || (root.left == null && root.right == null && !isLeft)) {
            return 0;
        }
        int sum = isLeft && isLeaves ? root.val : 0;
        if (root.left != null) {
            sum += sum(root.left, true, root.left.left == null && root.left.right == null);
        }
        if (root.right != null) {
            sum += sum(root.right, false, root.right.left == null && root.right.right == null);
        }
        return sum;
    }

}
