package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 输入：二叉树：[3,9,20,null,null,15,7]
 * 输出：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * @ClassName BinaryTreeLevelOrderTraversal
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/28 12:43
 * @Version V1.0
 **/
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder12313(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode curLevelEnd = root, nextLevelEnd = null;
        List<Integer> nodeValList = new ArrayList<>();
        while (!queue.isEmpty()) {
            root = queue.poll();
            nodeValList.add(root.val);

            if (root.left != null) {
                queue.add(root.left);
                nextLevelEnd = root.left;
            }
            if (root.right != null) {
                queue.add(root.right);
                nextLevelEnd = root.right;
            }

            if (root == curLevelEnd) {
                result.add(nodeValList);
                curLevelEnd = nextLevelEnd;
                nodeValList = new ArrayList<>();
            }
        }
        return result;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        List<Integer> list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmpNode;
        while (!queue.isEmpty()) {
            list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                tmpNode = queue.poll();
                list.add(tmpNode.val);
                if (tmpNode.left != null) {
                    queue.add(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    queue.add(tmpNode.right);
                }
            }
            res.add(list);
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
