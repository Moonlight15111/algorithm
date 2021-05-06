package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 输入:
 *     1
 *    / \
 *   3   2
 *  / \   \
 * 5   3   9
 * 输出: [1, 3, 9]
 *
 * @author Moonlight
 * @date 2021/5/6 12:43
 */
public class LargestValues {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(largestValues(root));
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        int max, size;
        while (!queue.isEmpty()) {
            size = queue.size();
            max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                max = Math.max(node.val, max);
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