package com.moonlight.algorithm.train.dfs;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 */
public class KthLargest {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        r.left = new TreeNode(3);
        r.left.left = new TreeNode(2);
        r.left.left.left = new TreeNode(1);
        r.left.right = new TreeNode(4);
        r.right = new TreeNode(6);

        System.out.println(kthLargest(r, 3));
    }

    static int res = 0, n;
    public static int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            if (k == 1) {
                return root.val;
            }
            return -1;
        }
//        List<Integer> list = new ArrayList<>();
//        dfs(root, list);
//        return list.get(list.size() - k);
        n = k;
        dfs(root);
        return res;
    }

    private static void dfs(TreeNode root) {
        if (root == null || n == 0) {
            return;
        }
        dfs(root.right);
        if (--n == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}