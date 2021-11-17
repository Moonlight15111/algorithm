package com.moonlight.algorithm.train.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/sZ59z6/
 *
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。
 * 请帮小扣计算巨型焰火有多少种不同的颜色。
 *
 * 输入：root = [1,3,2,1,null,2]  输出：3
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 *
 * 输入：root = [3,3,3]  输出：1
 * 解释：焰火中仅出现 1 个颜色，值为 3
 *
 * @author Moonlight
 */
public class NumColor {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(3);
        r.left.left = new TreeNode(1);
        r.right = new TreeNode(2);
        r.right.left = new TreeNode(2);

        System.out.println(numColor(r));
    }

    public static int numColor(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        return set.size();
    }

    private static void dfs(TreeNode root, Set<Integer> set) {
        if (root != null) {
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
        }
    }

}
