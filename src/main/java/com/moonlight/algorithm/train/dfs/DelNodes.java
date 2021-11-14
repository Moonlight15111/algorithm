package com.moonlight.algorithm.train.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/delete-nodes-and-return-forest/
 *
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]  输出：[[1,2,null,4],[6],[7]]
 *
 * @ClassName DelNodes
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/11/14 13:52
 * @Version V1.0
 **/
public class DelNodes {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(5);
        r.right = new TreeNode(3);
        r.right.left = new TreeNode(6);
        r.right.right = new TreeNode(7);

        List<TreeNode> treeNodes = delNodes(r, new int[]{3, 5});
        for (TreeNode node : treeNodes) {
            StringBuilder sb = new StringBuilder();
            print(node, sb);
            System.out.println(sb);
        }
    }

    private static void print(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#, ");
            return;
        }
        sb.append(node.val).append(", ");
        print(node.left, sb);
        print(node.right, sb);
    }

    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        for (int n : to_delete) {
           list.add(n);
        }

        List<TreeNode> ans = new ArrayList<>();

        dfs(root, true, list, ans);

        return ans;
    }

    private static TreeNode dfs(TreeNode root, boolean isRootNode, List<Integer> delVal, List<TreeNode> ans) {
        if (root == null) {
            return null;
        }
        boolean contains = delVal.contains(root.val);
        if (isRootNode && !contains) {
            ans.add(root);
        }
        root.left = dfs(root.left, contains, delVal, ans);
        root.right = dfs(root.right, contains, delVal, ans);
        return contains ? null : root;
    }

}
