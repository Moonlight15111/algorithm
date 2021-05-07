package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 *
 * 输入：root = [0,null,1]  输出：[1,null,1]
 *
 * 输入：root = [3,2,4,1]   输出：[7,9,4,10]
 *
 * @author Moonlight
 * @date 2021/5/7 17:58
 */
public class ConvertBstToGreaterTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

//        root = inorder(root);
        root = reInOrder(root);
        System.out.println(pinrt(root));
    }

    private static String pinrt(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            builder.append(poll.val).append(", ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return builder.toString();
    }

    static int sum = 0;
    public static TreeNode reInOrder(TreeNode root) {
        if (root != null) {
            reInOrder(root.right);
            sum += root.val;
            root.val = sum;
            reInOrder(root.left);
        }
        return root;
    }

    public static TreeNode inorder(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        in(root, stack);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            sum += pop.val;
            pop.val = sum;
        }
        return root;
    }

    private static void in(TreeNode root, Stack<TreeNode> stack) {
        if (root != null) {
            in(root.left, stack);
            stack.add(root);
            in(root.right, stack);
        }
    }

}
