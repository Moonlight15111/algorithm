package com.moonlight.algorithm.train.tree;

import com.moonlight.algorithm.train.list.TreeNode;

/**
 * 求树的最小高度
 * @ClassName TreeMinHeight
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/29 21:26
 * @Version V1.0
 **/
public class TreeMinHeight {

    public static int treeMinHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return process(root);
    }

    private static int process(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE;
        if (root.left != null) {
            left = process(root.left);
        }
        int right = Integer.MAX_VALUE;
        if (root.right != null) {
            right = process(root.right);
        }
        return 1 + Math.min(left, right);
    }

}