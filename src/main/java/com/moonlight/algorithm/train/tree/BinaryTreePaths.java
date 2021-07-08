package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 输入:
 *      1
 *    /   \
 *   2     3
 *    \
 *     5
 * 输出: ["1->2->5", "1->3"]
 *
 * @author Moonlight
 * @date 2021/7/8 11:14
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreePaths(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add("" + root.val);
            return ans;
        }
        StringBuilder left = new StringBuilder(), right = new StringBuilder();
        pre(root.left, left.append(root.val), ans);
        pre(root.right, right.append(root.val), ans);
        return ans;
    }

    private static void pre(TreeNode root, StringBuilder path, List<String> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(path.append("->").append(root.val).toString());
            return;
        }
        path.append("->").append(root.val);
        StringBuilder left = new StringBuilder(path);
        StringBuilder right = new StringBuilder(path);
        pre(root.left, left, ans);
        pre(root.right, right, ans);
    }

}
