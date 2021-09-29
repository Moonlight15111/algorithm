package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent/
 *
 * 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：
 *   该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
 * 如果不存在祖父节点值为偶数的节点，那么返回 0 。
 *
 * 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]  输出：18
 * 解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
 */
public class SumEvenGrandparent {

    public static void main(String[] args) {
        TreeNode r = new TreeNode(6);
        r.left = new TreeNode(7);
        r.left.left = new TreeNode(2);
        r.left.left.left = new TreeNode(9);
        r.left.right = new TreeNode(7);
        r.left.right.left = new TreeNode(1);
        r.left.right.right = new TreeNode(4);
        r.right = new TreeNode(8);
        r.right.left = new TreeNode(1);
        r.right.right = new TreeNode(3);
        r.right.right.right = new TreeNode(5);

        System.out.println(sumEvenGrandparent(r));
    }

    static int ans = 0;
    public static int sumEvenGrandparent(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            dfs(root, root.left, root.left.left);
            dfs(root, root.left, root.left.right);
        }
        if (root.right != null) {
            dfs(root, root.right, root.right.left);
            dfs(root, root.right, root.right.right);
        }
        return ans;
    }

    private static void dfs(TreeNode g, TreeNode p, TreeNode s) {
        if (s == null) {
            return;
        }
        if ((g.val & 1) == 0) {
            ans += s.val;
        }
        dfs(p, s, s.left);
        dfs(p, s, s.right);
    }

}
