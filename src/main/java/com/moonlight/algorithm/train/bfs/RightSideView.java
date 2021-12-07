package com.moonlight.algorithm.train.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/WNC0Lk/
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 输入: [1,2,3,null,5,null,4]  输出: [1,3,4]
 *
 * 输入: [1,null,3]  输出: [1,3]
 *
 * @author Moonlight
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.left.right = new TreeNode(5);
        a.right = new TreeNode(3);
        a.right.right = new TreeNode(4);

        System.out.println(rightSideView(a));

        TreeNode b = new TreeNode(1);
        b.right = new TreeNode(3);

        System.out.println(rightSideView(b));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            TreeNode poll;
            int size = 0;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int i = 0; i < size; i++) {
                    poll = queue.poll();
                    if (poll.left != null) {
                        queue.add(poll.left);
                    }
                    if (poll.right != null) {
                        queue.add(poll.right);
                    }
                    if (i == size - 1) {
                        ans.add(poll.val);
                    }
                }
            }
        }

        return ans;
    }

}