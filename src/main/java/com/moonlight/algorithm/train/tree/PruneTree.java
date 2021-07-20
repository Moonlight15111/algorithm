package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/binary-tree-pruning/
 *
 * 给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
 *
 * 输入: [1,null,0,0,1]   输出: [1,null,0,null,1]
 *
 * 输入: [1,0,1,0,0,0,1]  输出: [1,null,1,null,1]
 *
 * 输入: [1,1,0,1,1,0,1,0]  输出: [1,1,0,1,1,null,1]
 *
 * @author Moonlight
 * @date 2021/7/20 14:42
 */
public class PruneTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        root = pruneTree(root);
        StringBuilder str = new StringBuilder();
        print(root, str);
        System.out.println(str);
    }

    public static void print(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append("#,");
            return;
        }
        str.append(root.val).append(",");
        print(root.left, str);
        print(root.right, str);
    }

    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return recursion(root) ? root : null;
    }

    private static boolean recursion(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = recursion(root.left);
        boolean right = recursion(root.right);
        if (!left) {
            root.left = null;
        }
        if (!right) {
            root.right = null;
        }
        return root.val == 1 || left || right;
    }

}
