package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/longest-univalue-path/
 *
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 输入:
 *        5
 *       / \
 *      4   5
 *     / \   \
 *    1   1   5
 * 输出: 2
 *
 * 输入:
 *       1
 *      / \
 *     4   5
 *    / \   \
 *   4   4   5
 * 输出: 2
 *
 * @author Moonlight
 */
public class LongestUnivaluePath {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(4);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(4);

        r.right = new TreeNode(5);
        r.right.right = new TreeNode(5);

        System.out.println(longestUnivaluePath(r));
    }

    static int ans = 0;
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return ans;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left), r = dfs(root.right), ls = 0, rs = 0;
        if (root.left != null && root.left.val == root.val) {
            ls += l + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rs += r + 1;
        }
        ans = Math.max(ans, ls + rs);
        return Math.max(ls, rs);
    }

}
