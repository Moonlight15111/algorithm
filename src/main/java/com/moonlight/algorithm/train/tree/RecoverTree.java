package com.moonlight.algorithm.train.tree;
/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 *
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 */
public class RecoverTree {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(3);
        r1.left.right = new TreeNode(2);

        recoverTree(r1);

        StringBuilder sb = new StringBuilder();
        inOrder(r1, sb);

        System.out.println(sb.toString());
    }

    public static void inOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        inOrder(root.left, sb);
        sb.append(root.val).append(",");
        inOrder(root.right, sb);
    }

    static TreeNode f = null, s = null, p = null;
    public static void recoverTree(TreeNode root) {
        // 1. 找到两个错位的节点
        in(root);
        // 2. 交换两个节点的值
        int t = f.val;
        f.val = s.val;
        s.val = t;
    }

    private static void in(TreeNode root) {
        if (root == null) {
            return;
        }
        in(root.left);
        if (f == null && p != null && p.val > root.val) {
            f = p;
        }
        if (f != null && p != null && p.val > root.val) {
            s = root;
        }
        p = root;
        in(root.right);
    }

}
