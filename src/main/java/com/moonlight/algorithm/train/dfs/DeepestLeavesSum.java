package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 *
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 * 输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * 输出：15
 *
 * @author Moonlight
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);
        r.left.left.left = new TreeNode(7);
        r.right = new TreeNode(3);
        r.right.right = new TreeNode(6);
        r.right.right.right = new TreeNode(8);

        System.out.println(deepestLeavesSum(r));
    }

    static int sum;
    public static int deepestLeavesSum(TreeNode root) {
        int maxDepth = maxDepth(root);
        sum = 0;
        dfs(root, 1, maxDepth);
        return sum;
    }

    private static void dfs(TreeNode root, int curDepth, int maxDepth) {
        if (root == null) {
            return;
        }
        if (curDepth == maxDepth) {
            sum += root.val;
        }
        dfs(root.left, curDepth + 1, maxDepth);
        dfs(root.right, curDepth + 1, maxDepth);
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left), right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

}