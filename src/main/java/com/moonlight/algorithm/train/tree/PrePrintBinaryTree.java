package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一颗二叉树，从根节点开始，按照前序遍历的顺序打印所有的节点，
 * 每次打印完一颗子树后再打印一次根节点
 *
 * 输入:  2
 *     3    4
 *   5   6    7
 * 输出: 2, 3, 5, 3, 6, 3, 2, 4, 7, 4, 2
 *
 * 输入:  1
 *      2
 * 输出: 1, 2, 1
 *
 * 输入:   1
 *     2     3
 *        4     6
 *      5
 * 输出: 1, 2, 1, 3, 4, 5, 4, 3, 6, 3, 1
 *
 * @author Moonlight
 * @date 2021/3/12 11:47
 */
public class PrePrintBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        StringBuilder builder = new StringBuilder();
        prePrint(root, null, builder);
        System.out.println(builder.toString());
    }

    public static void prePrint(TreeNode root, TreeNode preRoot, StringBuilder builder) {
        if (root == null) {
            return;
        }
        builder.append(root.val).append(", ");
        prePrint(root.left, root, builder);
        prePrint(root.right, root, builder);
        if (preRoot != null) {
            builder.append(preRoot.val).append(", ");
        }
    }


    private static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
