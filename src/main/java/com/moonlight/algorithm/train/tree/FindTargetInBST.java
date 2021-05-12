package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 *
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 输入:    Target = 9  输出: True    Target = 28  输出: False
 *      5
 *     / \
 *    3   6
 *   / \   \
 *  2   4   7
 *
 * @author Moonlight
 * @date 2021/5/12 13:16
 */
public class FindTargetInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(dfs(root, 9));
        System.out.println(dfs(root, 28));
    }

    public static boolean dfs(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        return dfs(root, list, k);
    }

    private static boolean dfs(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return false;
        }
        if (list.contains(k - root.val)) {
            return true;
        }
        list.add(root.val);
        return dfs(root.left, list, k) || dfs(root.right, list, k);
    }

}
