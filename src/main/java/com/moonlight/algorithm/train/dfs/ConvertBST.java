package com.moonlight.algorithm.train.dfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/w6cpku/
 *
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 *
 * 输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 输入：root = [0,null,1]  输出：[1,null,1]
 *
 * 输入：root = [1,0,2]  输出：[3,3,2]
 *
 * 输入：root = [3,2,4,1]  输出：[7,9,4,10]
 *
 * @author Moonlight
 */
public class ConvertBST {

    public static void  main(String[] args) {
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(1);
        a.left.left = new TreeNode(0);
        a.left.right = new TreeNode(2);
        a.left.right.right = new TreeNode(3);
        a.right = new TreeNode(6);
        a.right.left = new TreeNode(5);
        a.right.right = new TreeNode(7);
        a.right.right.right = new TreeNode(8);

        TreeNode node = convertBST(a);
        System.out.println(print(node));
    }

    private static List<Integer> print(TreeNode node) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            ans.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return ans;
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        inorder(root, stack);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sum += pop.val;
            pop.val = sum;
        }
        return root;
    }

    private static void inorder(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        inorder(root.left, stack);
        stack.add(root);
        inorder(root.right, stack);
    }

}
