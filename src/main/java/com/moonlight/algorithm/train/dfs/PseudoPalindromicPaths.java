package com.moonlight.algorithm.train.dfs;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 *
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，
 * 当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 *
 * 输入：root = [2,3,1,3,1,null,1]  输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 *      在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 *
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]  输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 *      这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 *
 * 输入：root = [9]  输出：1
 *
 * @author Moonlight
 */
public class PseudoPalindromicPaths {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2), b = new TreeNode(2), c = new TreeNode(9);
        a.left = new TreeNode(3);
        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(1);
        a.right = new TreeNode(1);
        a.right.right = new TreeNode(1);

        b.left = new TreeNode(1);
        b.left.left = new TreeNode(1);
        b.left.right = new TreeNode(3);
        b.left.right.right = new TreeNode(1);
        b.right = new TreeNode(1);

        System.out.println(pseudoPalindromicPaths(a));
        System.out.println(pseudoPalindromicPaths(b));
        System.out.println(pseudoPalindromicPaths(c));
    }

    static int ans;
    public static int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        ans = 0;
        dfs(root, new int[10]);
        return ans;
    }

    private static void dfs(TreeNode root, int[] cnt) {
        if (root == null) {
            return;
        }
        cnt[root.val]++;
        if (root.left == null && root.right == null && valid(cnt)) {
            ans++;
            return;
        }
        if (root.left != null) {
            dfs(root.left, Arrays.copyOf(cnt, cnt.length));
        }
        if (root.right != null) {
            dfs(root.right, Arrays.copyOf(cnt, cnt.length));
        }
    }

    private static boolean valid(int[] cnt) {
        int num = 0;
        for (int n : cnt) {
            if ((n & 1) == 1) {
                num++;
            }
        }
        return num < 2;
    }

}
