package com.moonlight.algorithm.train.recursion;

import com.moonlight.algorithm.train.list.TreeNode;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author Moonlight
 * @date 2021/1/13 16:30
 */
public class IsValidBST {

    long head = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.val <= head) {
            return false;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        head = root.val;
        return isValidBST(root.right);
    }

}
