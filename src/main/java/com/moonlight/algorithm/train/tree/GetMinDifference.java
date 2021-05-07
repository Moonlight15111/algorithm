package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 输入： 1
 *        \
 *        3
 *       /
 *      2
 * 输出：1
 * 解释: 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 *
 * @author Moonlight
 * @date 2021/5/7 17:19
 */
public class GetMinDifference {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(236);
        root.left = new TreeNode(104);
        root.left.right = new TreeNode(227);
        root.right = new TreeNode(701);
        root.right.right = new TreeNode(911);

        System.out.println(getMinimumDifference(root));
    }

    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int ans = Integer.MAX_VALUE, prev = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev == Integer.MIN_VALUE) {
                    prev = root.val;
                } else {
                    ans = Math.min(ans, Math.abs(root.val - prev));
                    prev = root.val;
                }
                root = root.right;
            }
        }

        return ans;
    }
}
