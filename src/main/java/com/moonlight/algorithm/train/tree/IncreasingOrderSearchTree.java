package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 *
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 *
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * 输入：root = [5,1,7]  输出：[1,null,5,null,7]
 *
 * @author Moonlight
 * @date 2021/4/25 13:19
 */
public class IncreasingOrderSearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

//        root = list(root);
        root = changePtr(root);
        print(root);
    }

    private static void print(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ", ");
            print(root.left);
            print(root.right);
        } else {
            System.out.print("null, ");
        }
    }

    static TreeNode dummy = new TreeNode(-1);
    static TreeNode node = dummy;
    public static TreeNode changePtr(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        in(root);
        return dummy.right;
    }

    private static void in(TreeNode root) {
        if (root == null) {
            return;
        }
        in(root.left);

        node.right = root;
        root.left = null;
        node = root;

        in(root.right);
    }

    public static TreeNode list(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        List<Integer> vals = new ArrayList<>();
        in(root, vals);

        TreeNode nr = new TreeNode(vals.get(0));
        TreeNode cur = nr;
        for (int i = 1; i < vals.size(); i++) {
            cur.right = new TreeNode(vals.get(i));
            cur = cur.right;
        }
        return nr;
    }

    private static void in(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        in(root.left, vals);
        vals.add(root.val);
        in(root.right, vals);
    }

}
