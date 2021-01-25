package com.moonlight.algorithm.search;

import com.moonlight.algorithm.train.list.TreeNode;

/**
 * 给定两棵树的头结点big/small，求big是否有某棵子树的数据结构，是和small的数据结构一样的
 * @ClassName TreeEqual
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/25 21:24
 * @Version V1.0
 **/
public class TreeEqual {

    public static boolean treeEqual(TreeNode big, TreeNode small) {
        if (big == null) {
            return false;
        }
        if (small == null) {
            return true;
        }
        if (isSameValueTree(big, small)) {
            return true;
        }
        return treeEqual(big.left, small) || treeEqual(big.right, small);
    }

    private static boolean isSameValueTree(TreeNode big, TreeNode small) {
        if (big == null && small == null) {
            return true;
        }
        if (big == null || small == null || big.val != small.val) {
            return false;
        }
        return isSameValueTree(big.left, small.left) && isSameValueTree(big.right, small.right);
    }


}
