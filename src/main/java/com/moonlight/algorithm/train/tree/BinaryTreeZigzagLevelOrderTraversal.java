package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 输入：给定二叉树 [3,9,20,null,null,15,7],
 * 输出：
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 *
 * @ClassName BinaryTreeZigzagLevelOrderTraversal
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/28 13:31
 * @Version V1.0
 **/
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int level = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmpNode;
        while (!queue.isEmpty()) {
            Deque<Integer> deque = new LinkedList<>();
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                tmpNode = queue.poll();
                // 偶数层
                if ((level & 1) == 0) {
                    deque.addLast(tmpNode.val);
                } else {
                    deque.addFirst(tmpNode.val);
                }
                if (tmpNode.left != null) {
                    queue.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.offer(tmpNode.right);
                }
            }
            res.add(new LinkedList<>(deque));
        }
        return res;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
