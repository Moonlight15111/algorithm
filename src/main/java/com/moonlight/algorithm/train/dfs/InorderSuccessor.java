package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/successor-lcci/
 *
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 *
 * 输入: root = [2,1,3], p = 1  输出: 2
 *   2
 *  / \
 * 1   3
 *
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6  输出: null
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 *
 * @author Moonlight
 */
public class InorderSuccessor {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(3);

        TreeNode b = new TreeNode(5);
        b.left = new TreeNode(3);
        b.left.left = new TreeNode(2);
        b.left.left.left = new TreeNode(1);
        b.left.right = new TreeNode(4);
        b.right = new TreeNode(6);

        TreeNode node = inorderSuccessor(a, a.left);
        System.out.println(node == null ? "null" : node.val);
        node = inorderSuccessor(b, b.right);
        System.out.println(node == null ? "null" : node.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(p) && i < list.size() - 1) {
                return list.get(i + 1);
            }
        }
        return null;
    }

    private static void inOrder(TreeNode root,List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

}
