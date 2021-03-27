package com.moonlight.algorithm.train.tree;

import org.omg.CORBA.StringHolder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * 输入：root = []  输出：[]
 * <p>
 * 输入：root = [0] 输出：[0]
 *
 * @ClassName FlattenBinaryTreeToLinkedList
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/27 17:01
 * @Version V1.0
 **/
public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(5));
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten1231(root);

        StringBuilder builder = new StringBuilder();
        printTree(root, builder);
        System.out.println(builder.toString());
    }

    public static void printTree (TreeNode root, StringBuilder s) {
        if (root == null) {
            s.append("null, ");
            return;
        }
        s.append(root.val).append(", ");
        printTree(root.left, s);
        printTree(root.right, s);
    }

    static TreeNode dummy = new TreeNode();
    public static void flatten1231(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;

        dummy.right = root;
        dummy.left = null;
        dummy = root;

        flatten(left);
        flatten(right);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        prev(root, list);

        TreeNode prev, cur;
        for (int i = 1, size = list.size(); i < size; i++) {
            prev = list.get(i - 1);
            cur = list.get(i);
            prev.right = cur;
            prev.left = null;
        }
    }

    private static void prev(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        prev(root.left, list);
        prev(root.right, list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() { }

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
