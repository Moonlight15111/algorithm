package com.moonlight.algorithm.train.tree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 *
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。叶节点 是指没有子节点的节点。
 *
 * 输入：root = [1,2,3]   输出：25
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
 * @ClassName SumRootToLeafNumbers
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/9 16:11
 * @Version V1.0
 **/
public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(0);

        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        i = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return i;
        }
        return dfs(root.left, i) + dfs(root.right, i);
    }

}
