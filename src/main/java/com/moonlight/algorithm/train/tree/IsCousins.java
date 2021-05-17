package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * <p>
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 输入：root = [1,2,3,4], x = 4, y = 3   输出：false
 * <p>
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4   输出：true
 * <p>
 * 输入：root = [1,2,3,null,4], x = 2, y = 3   输出：false
 * <p>
 * 1. 二叉树的节点数介于 2 到 100 之间。
 * 2. 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * @author Moonlight
 * @date 2021/5/17 13:10
 */
public class IsCousins {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        System.out.println(isCousins(root, 4, 5));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }
        TreeNode xp = dfs(root, x), yp = dfs(root, y);
        int xk = depth(root, x, 0), yk = depth(root, y, 0);
        return xp != yp && xk == yk;
    }

    private static TreeNode dfs(TreeNode root, int n) {
        if (root == null) {
            return null;
        }
        if (root.left != null && root.left.val == n) {
            return root;
        }
        if (root.right != null && root.right.val == n) {
            return root;
        }
        TreeNode left = dfs(root.left, n);
        TreeNode right = dfs(root.right, n);

        return left == null ? right : left;
    }

    private static int depth(TreeNode root, int t, int k) {
        if (root == null) {
            return 0;
        }
        if (root.val == t) {
            return k;
        }
        int left = depth(root.left, t, k + 1);
        int right = depth(root.right, t, k + 1);

        return Math.max(left, right);
    }

}
