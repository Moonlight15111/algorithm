package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 *
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 *
 * 输入：root = [1,0,1,0,1,0,1]  输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *
 * 输入：root = [0]  输出：0
 *
 * 输入：root = [1]  输出：1
 *
 * 输入：root = [1,1]  输出：3
 *
 * @author Moonlight
 */
public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(0);
        r.left.left = new TreeNode(0);
        r.left.right = new TreeNode(1);
        r.right = new TreeNode(1);
        r.right.left = new TreeNode(0);
        r.right.right = new TreeNode(1);

        System.out.println(sumRootToLeaf(r));
    }

    static int ans = 0;
    public static int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        dfs(root, 0);
        return ans;
    }

    private static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum = (sum << 1) + root.val;
        if (root.left == null && root.right == null) {
            ans += sum;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

}