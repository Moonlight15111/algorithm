package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/path-sum/
 *
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 * @author Moonlight
 * @date 2021/3/29 16:53
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);

        System.out.println(hasPathSum(root, -1));
        System.out.println(hasPathSum1231(root, -1));
    }

    public static boolean hasPathSum1231(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum1231(root.left, targetSum - root.val) || hasPathSum1231(root.right, targetSum - root.val);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null || (root.left == null && root.right == null && root.val != targetSum)) {
            return false;
        }
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, root.val, targetSum) || hasPathSum(root.right, root.val, targetSum);
    }

    private static boolean hasPathSum(TreeNode node, int curSum, int targetSum) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null && curSum + node.val == targetSum) {
            return true;
        }
        return hasPathSum(node.left, curSum + node.val, targetSum) || hasPathSum(node.right, curSum + node.val, targetSum);
    }

}