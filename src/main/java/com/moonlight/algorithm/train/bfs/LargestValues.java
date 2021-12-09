package com.moonlight.algorithm.train.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/hPov7L/
 *
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 *
 * 输入: root = [1,3,2,5,3,null,9]  输出: [1,3,9]
 *
 * 输入: root = [1,2,3]  输出: [1,3]
 *
 * @author Moonlight
 */
public class LargestValues {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(3);
        a.left.left = new TreeNode(5);
        a.left.right = new TreeNode(3);
        a.right = new TreeNode(2);
        a.right.right = new TreeNode(9);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);

        System.out.println(largestValues(a));
        System.out.println(largestValues(b));
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        int max, size;
        while (!queue.isEmpty()) {
            max = Integer.MIN_VALUE;
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(max);
        }

        return ans;
    }

}
