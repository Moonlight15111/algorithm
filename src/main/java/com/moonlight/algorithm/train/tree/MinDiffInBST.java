package com.moonlight.algorithm.train.tree;

import java.util.PriorityQueue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 输入：root = [4,2,6,1,3]   输出：1
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]  输出：1
 * <p>
 * 树中节点数目在范围 [2, 100] 内   0 <= Node.val <= 105
 *
 * @author Moonlight
 * @date 2021/4/13 13:12
 */
public class MinDiffInBST {

    int pre = Integer.MIN_VALUE, res = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == Integer.MIN_VALUE) {
            pre = root.val;
        } else {
            res = Math.min(res, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

}
