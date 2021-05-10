package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 *
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 * 给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 *
 * 输入：root1 = [1], root2 = [1]   输出：true
 *
 * 输入：root1 = [1], root2 = [2]   输出：false
 *
 * 输入：root1 = [1,2], root2 = [2,2]  输出：true
 *
 * 输入：root1 = [1,2,3], root2 = [1,3,2]   输出：false
 *
 * @author Moonlight
 * @date 2021/5/10 12:42
 */
public class LeafSimilar {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(3);
        r2.right = new TreeNode(2);

        System.out.println(leafSimilar(r1, r2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, list1);
        }
        List<Integer> list2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, list2);
        }

        return list1.equals(list2);
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }

}