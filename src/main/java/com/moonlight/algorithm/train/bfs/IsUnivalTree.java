package com.moonlight.algorithm.train.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 *
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 *
 * 输入：[1,1,1,1,1,null,1]  输出：true
 *
 * 输入：[2,2,2,5,2]  输出：false
 *
 */
public class IsUnivalTree {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(1);
        r.left.left = new TreeNode(1);
        r.left.right = new TreeNode(1);

        r.right = new TreeNode(1);
        r.right.right = new TreeNode(1);


        System.out.println(isUnivalTree(r));

        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(5);
        a.left.right = new TreeNode(2);

        a.right = new TreeNode(2);

        System.out.println(isUnivalTree(a));
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode c = root;
        q.add(c);
        int n = c.val;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                c = q.poll();
                if (n != c.val) {
                    return false;
                } else {
                    n = c.val;
                }
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
        }
        return true;
    }

}
