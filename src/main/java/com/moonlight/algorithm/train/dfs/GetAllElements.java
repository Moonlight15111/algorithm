package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 *
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 *
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 *
 * 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * 输出：[-10,0,0,1,2,5,7,10]
 *
 * 输入：root1 = [], root2 = [5,1,7,0,2]
 * 输出：[0,1,2,5,7]
 *
 * 输入：root1 = [0,-10,10], root2 = []
 * 输出：[-10,0,10]
 *
 * @author Moonlight
 */
public class GetAllElements {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(4);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(0);
        b.right = new TreeNode(3);

        System.out.println(getAllElements(a, b));
    }

    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        dfs(root1, ans);
        dfs(root2, ans);
        ans.sort(Integer::compareTo);
        return ans;
    }

    private static void dfs(TreeNode root, List<Integer> ans) {
        if (root != null) {
            dfs(root.left, ans);
            ans.add(root.val);
            dfs(root.right, ans);
        }
    }

}