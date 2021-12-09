package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/3Etpl5/
 *
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *    例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 *
 * 输入：root = [1,2,3]  输出：25
 * 解释：从根到叶子节点路径 1->2 代表数字 12
 *      从根到叶子节点路径 1->3 代表数字 13
 *      因此，数字总和 = 12 + 13 = 25
 *
 * 输入：root = [4,9,0,5,1]  输出：1026
 * 解释：从根到叶子节点路径 4->9->5 代表数字 495
 *      从根到叶子节点路径 4->9->1 代表数字 491
 *      从根到叶子节点路径 4->0 代表数字 40
 *      因此，数字总和 = 495 + 491 + 40 = 1026
 *
 * @author Moonlight
 */
public class SumNumbers {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(9);
        b.left.left = new TreeNode(5);
        b.left.right = new TreeNode(1);
        b.right = new TreeNode(0);

        System.out.println(sumNumbers(a));
        System.out.println(sumNumbers(b));
    }

    static int ans = 0;
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private static void dfs(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        cur = 10 * cur + root.val;
        if (root.left == null && root.right == null) {
            ans += cur;
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }

}