package com.moonlight.algorithm.train.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 *
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 输入:
 *       1
 *     /   \
 *    3     2
 *   / \     \
 *  5   3     9
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 *
 * 输入:
 *      1
 *     / \
 *    3   2
 *   /
 *  5
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 *
 * 输入:
 *         1
 *        / \
 *       3   2
 *     /     \
 *    5       9
 *   /         \
 *  6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 *
 * @author Moonlight
 * @date 2021/5/19 13:22
 */
public class WidthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
//        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);

        System.out.println(widthOfBinaryTree(root));
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        /*
        题目中定义的宽度，刚好对应完全二叉树的特性，每一层的层宽，等于完全二叉树中对应节点的编号差. 如:
       1
      / \
     3   2
    / \   \
   5   3   9
节点在满二叉树中的编号值
       1
      / \
     2   3
    / \   \
   4   5   7
   由上可得：层宽 = 每一层的最右侧编号 - 最左侧编号 + 1
         */
        int ans = 0, size;
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            ans = Math.max(ans, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    poll.left.val = poll.val * 2 + 1;
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    poll.right.val = poll.val * 2 + 2;
                    queue.add(poll.right);
                }
            }
        }
        return ans;
    }

}
