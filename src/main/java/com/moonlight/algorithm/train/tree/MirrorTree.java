package com.moonlight.algorithm.train.tree;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class MirrorTree {

    public static void main(String[] args){
        TreeNode r = new TreeNode(4);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(1);
        r.left.right = new TreeNode(3);
        r.right = new TreeNode(7);
        r.right.left = new TreeNode(6);
        r.right.right = new TreeNode(9);

        TreeNode node = mirrorTree(r);
        StringBuilder s = new StringBuilder();
        p(node, s);
        System.out.println(s.toString());
    }

    public static void p(TreeNode r, StringBuilder s) {
        if (r == null) {
            s.append("#, ");
            return;
        }
        s.append(r.val).append(", ");
        p(r.left, s);
        p(r.right, s);
    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode ans = new TreeNode(root.val);
        if (root.left == null && root.right == null) {
            return ans;
        }
        ans.left = mirrorTree(root.right);
        ans.right = mirrorTree(root.left);
        return ans;
    }

}