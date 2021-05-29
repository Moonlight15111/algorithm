package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * 输入：root = [4,2,7,1,3], val = 5   输出：[4,2,7,1,3,5]
 *
 * 输入：root = [40,20,60,10,30,50,70], val = 25  输出：[40,20,60,10,30,50,70,null,null,25]
 *
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5  输出：[4,2,7,1,3,5]
 *
 * @author Moonlight
 * @date 2021/5/25 13:15
 */
public class InsertIntoBST {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        TreeNode node = insertIntoBST(root, 5);

//        TreeNode root = new TreeNode(40);
//        root.left = new TreeNode(20);
//        root.right = new TreeNode(60);
//        root.left.left = new TreeNode(10);
//        root.left.right = new TreeNode(30);
//        root.right.left = new TreeNode(50);
//        root.right.right = new TreeNode(70);
//        TreeNode node = insertIntoBST(root, 25);

        TreeNode root = new TreeNode(4);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(77);
        root.right.right.right = new TreeNode(95);
        TreeNode node = insertIntoBST(root, 5);
//        TreeNode node = recursion(root, 5);


        print(node);
    }

    private static void print(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            System.out.print(poll.val + ", ");
            if (poll.left != null) {
                q.add(poll.left);
            }
            if (poll.right != null) {
                q.add(poll.right);
            }
        }
    }

    public static TreeNode recursion(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val > val) {
            root.left = recursion(root.left, val);
        }
        if (root.val < val) {
            root.right = recursion(root.right, val);
        }
        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        while (true) {
            if (val < cur.val) {
                if (cur.left == null) {
                    cur.left = new TreeNode(val);
                    break;
                }
                cur = cur.left;
            } else {
                if (cur.right == null) {
                    cur.right = new TreeNode(val);
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }

}
