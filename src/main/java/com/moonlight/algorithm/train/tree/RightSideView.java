package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 输入: [1,2,3,null,5,null,4]
 输出: [1, 3, 4]
 解释:
 *      1            <---
 *    /   \
 *   2     3         <---
 *    \     \
 *    5     4       <---
 *
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * @author Moonlight
 * @date 2021/7/6 16:19
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(node);
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (size - 1 == i) {
                    ans.add(node.val);
                }
            }
        }
        return ans;
    }

}
