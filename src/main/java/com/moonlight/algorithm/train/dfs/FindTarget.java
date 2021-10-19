package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/opLdQZ/
 *
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k ,
 * 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 12  输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 *
 * 输入: root = [8,6,10,5,7,9,11], k = 22  输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 */
public class FindTarget {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(8);

        r.left = new TreeNode(6);
        r.left.left = new TreeNode(5);
        r.left.right = new TreeNode(7);

        r.right = new TreeNode(10);
        r.right.left = new TreeNode(9);
        r.right.right = new TreeNode(11);

        System.out.println(findTarget(r, 12));
        System.out.println(findTarget(r, 22));

        System.out.println(twoPtr(r, 12));
        System.out.println(twoPtr(r, 22));
    }

    public static boolean twoPtr(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int l = 0, r = list.size() - 1, s;
        while (l < r) {
            s = list.get(l) + list.get(r);
            if (s > k) {
                r--;
            } else if (s < k) {
                l++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static void inOrder(TreeNode root, List<Integer> a) {
        if (root != null) {
            inOrder(root.left, a);
            a.add(root.val);
            inOrder(root.right, a);
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        return dfs(root, k, list);
    }

    private static boolean dfs(TreeNode root, int k, List<Integer> list) {
        if (root == null) {
            return false;
        }
        if (list.contains(k - root.val)) {
            return true;
        }
        list.add(root.val);
        return dfs(root.left, k, list) || dfs(root.right, k, list);
    }

}
