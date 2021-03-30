package com.moonlight.algorithm.train.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 输入：root = [1,2,3], targetSum = 5   输出：[]
 *
 * 输入：root = [1,2], targetSum = 0   输出：[]
 *
 * @author Moonlight
 * @date 2021/3/30 9:09
 */
public class PathSumII {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        for (List<Integer> list : pathSum(root, 22)) {
            System.out.println(list);
        }

        System.out.println("==================================");

        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(-2);
        rootNode.left.left = new TreeNode(1);
        rootNode.left.right = new TreeNode(3);
        rootNode.left.left.left = new TreeNode(-1);

        rootNode.right = new TreeNode(-3);
        rootNode.right.left = new TreeNode(-2);

        for (List<Integer> list : pathSum(rootNode, -1)) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null || (root.val != targetSum && root.left == null && root.right == null)) {
            return res;
        }

        if (root.val == targetSum && root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            res.add(list);
            return res;
        }
        dfs(root, targetSum, new ArrayList<>(), res);
        return res;
    }

    private static void dfs(TreeNode root, int targetSum, ArrayList<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (path.stream().mapToInt(Integer::intValue).sum() == targetSum) {
                res.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }
        dfs(root.left, targetSum, path, res);
        dfs(root.right, targetSum, path, res);
        path.remove(path.size() - 1);
    }
}
