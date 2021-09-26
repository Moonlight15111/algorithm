package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 *
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 *
 * 输入：7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],
 *       [0,0,0,null,null,0,0,0,0],
 *       [0,0,0,0,0,0,0],
 *       [0,0,0,0,0,null,null,null,null,0,0],
 *       [0,0,0,0,0,null,null,0,0]]
 *
 */
public class AllPossibleFBT {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = allPossibleFBT(7);
        for (TreeNode node : treeNodes) {
            StringBuilder sb = new StringBuilder();
            str(node, sb);
            System.out.println(sb.toString());
        }
    }

    private static void str(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null, ");
            return;
        }
        sb.append(root.val).append(", ");
        str(root.left, sb);
        str(root.right, sb);
    }

    public static List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        backtrack(n, ans);
        return ans;
    }

    private static void backtrack(int n, List<TreeNode> ans) {
        if (n == 1) {
            ans.add(new TreeNode(0));
            return;
        }
        for (int i = 1; i < n - 1; i += 2) {
            List<TreeNode> l = new ArrayList<>(), r = new ArrayList<>();
            backtrack(i, l);
            backtrack(n - i - 1, r);
            for (TreeNode ln : l) {
                for (TreeNode rn : r) {
                    TreeNode root = new TreeNode(0);
                    root.left = ln;
                    root.right = rn;
                    ans.add(root);
                }
            }
        }
    }

}
