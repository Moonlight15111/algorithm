package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * 输入：root = [3,1,4,null,2], k = 1           输出：1
 *
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3  输出：3
 *
 * @author Moonlight
 * @date 2021/7/6 18:05
 */
public class KthSmallestElementInABst {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(kthSmallest(root, 1));

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);

        System.out.println(kthSmallest(root2, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        in(root, list);
        return list.get(k - 1);
    }

    private static void in(TreeNode root, List<Integer> list) {
        if (root != null) {
            in(root.left, list);
            list.add(root.val);
            in(root.right, list);
        }
    }

}
