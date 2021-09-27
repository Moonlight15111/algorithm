package com.moonlight.algorithm.train.dfs;
/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 输入：root = [1,2,3]  输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 * 输入：root = [-10,9,20,null,null,15,7]  输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 */
public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.right = new TreeNode(3);

        System.out.println(maxPathSum(r));

        TreeNode a = new TreeNode(-10);
        a.left = new TreeNode(9);
        a.right = new TreeNode(20);
        a.right.left = new TreeNode(15);
        a.right.right = new TreeNode(7);

        System.out.println(maxPathSum(a));
    }

    static int ans = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        max(root);
        return ans;
    }

    private static int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(max(root.left), 0);
        int r = Math.max(max(root.right), 0);

        int s = root.val + l + r;

        ans = Math.max(ans, s);

        return root.val + Math.max(l, r);
    }

}