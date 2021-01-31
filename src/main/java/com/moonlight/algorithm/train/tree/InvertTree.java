package com.moonlight.algorithm.train.tree;

import com.moonlight.algorithm.train.list.TreeNode;

/**
 * 原题：https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转一棵二叉树。
 * 输入：
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * @ClassName InvertTree
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/31 18:41
 * @Version V1.0
 **/
public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

}
