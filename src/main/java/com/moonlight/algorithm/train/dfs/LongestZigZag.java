package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree/
 *
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *    选择二叉树中 任意 节点和一个方向（左或者右）。
 *    如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 *    改变前进方向：左变右或者右变左。
 *    重复第二步和第三步，直到你在树中无法继续移动。
 * 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 *
 * 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]  输出：3
 * 解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
 *
 * 输入：root = [1,1,1,null,1,null,null,1,1,null,1]  输出：4
 * 解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
 *
 * 输入：root = [1]  输出：0
 *
 * @author Moonlight
 */
public class LongestZigZag {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.right = new TreeNode(1);
        a.right.left = new TreeNode(1);
        a.right.right = new TreeNode(1);
        a.right.right.left = new TreeNode(1);
        a.right.right.left.right = new TreeNode(1);
        a.right.right.left.right.right = new TreeNode(1);
        a.right.right.right = new TreeNode(1);

        System.out.println(longestZigZag(a));

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(1);
        b.right = new TreeNode(1);
        b.left.right = new TreeNode(1);
        b.left.right.left = new TreeNode(1);
        b.left.right.left.right = new TreeNode(1);
        b.left.right.right = new TreeNode(1);

        System.out.println(longestZigZag(b));
    }

    static int ans = 0;
    public static int longestZigZag(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        ans = 0;
        dfs(root, true, 0);
        dfs(root, false, 0);
        return ans;
    }

    private static void dfs(TreeNode root, boolean isLeft, int len) {
        if (root == null) {
            return;
        }
        if (isLeft) {
            dfs(root.right, false, len + 1);
            dfs(root.left, true, 1);
        } else {
            dfs(root.left, true, len + 1);
            dfs(root.right, false, 1);
        }
        ans = Math.max(ans, len);
    }

}
