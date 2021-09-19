package com.moonlight.algorithm.train.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 输入:
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 */
public class FindFrequentTreeSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        TreeNode r2 = new TreeNode(5);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(-5);

        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
        System.out.println(Arrays.toString(findFrequentTreeSum(r2)));
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> m = new HashMap<>();

        post(root, m);

        int max = 0;
        for (Integer v : m.values()) {
            max = Math.max(v, max);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer k : m.keySet()) {
            if (m.get(k) >= max) {
                list.add(k);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private static int post(TreeNode root, Map<Integer, Integer> m) {
        if (root == null) {
            return 0;
        }
        int l = post(root.left, m);
        int r = post(root.right, m);
        int s = root.val + l + r;
        m.put(s, m.getOrDefault(s, 0) + 1);
        return s;
    }

}
