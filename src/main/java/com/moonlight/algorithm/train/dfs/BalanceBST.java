package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/balance-a-binary-search-tree/
 *
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * 如果有多种构造方法，请你返回任意一种。
 *
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 *
 * @author Moonlight
 */
public class BalanceBST {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(2);
        r.right.right = new TreeNode(3);
        r.right.right.right = new TreeNode(4);

        TreeNode node = balanceBST(r);
        StringBuilder sb = new StringBuilder();
        print(node, sb);
        System.out.println(sb.toString());
    }

    private static void print(TreeNode node, StringBuilder sb) {
        if (node != null) {
            sb.append(node.val).append(",");
            print(node.left, sb);
            print(node.right, sb);
        }
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> val = new ArrayList<>();
        inorderVal(root, val);
        return buildTree(0, val.size() - 1, val);
    }

    private static TreeNode buildTree(int left, int right, List<Integer> val) {
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(val.get(mid));
        if (left < mid) {
            root.left = buildTree(left, mid - 1, val);
        }
        if (right > mid) {
            root.right = buildTree(mid + 1, right, val);
        }
        return root;
    }

    private static void inorderVal(TreeNode root, List<Integer> val) {
        if (root == null) {
            return;
        }
        inorderVal(root.left, val);
        val.add(root.val);
        inorderVal(root.right, val);
    }

}
