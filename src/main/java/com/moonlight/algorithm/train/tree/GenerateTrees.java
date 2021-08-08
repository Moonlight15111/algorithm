package com.moonlight.algorithm.train.tree;

import com.moonlight.algorithm.train.stack.EvalRPN;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 *
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @ClassName GenerateTrees
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/8 14:04
 * @Version V1.0
 **/
public class GenerateTrees {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = generateTrees(3);
        for (TreeNode node : treeNodes) {
            StringBuilder sb = new StringBuilder();
            print(node, sb);
            System.out.println(sb.toString());
        }
    }

    private static void print(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null, ");
            return;
        }
        sb.append(root.val).append(", ");
        print(root.left, sb);
        print(root.right, sb);
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        return build(1, n);
    }

    private static List<TreeNode> build(int left, int right) {
        List<TreeNode> ans = new ArrayList<>();
        if (left > right) {
            ans.add(null);
            return ans;
        }
        if (left == right) {
            ans.add(new TreeNode(left));
            return ans;
        }
        TreeNode root;
        List<TreeNode> leftList, rightList;
        for (int i = left; i <= right; i++) {
            leftList = build(left, i - 1);
            rightList = build(i + 1, right);
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

}
