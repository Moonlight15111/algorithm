package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 给定的树 s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *     4
 *    / \
 *   1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 给定的树 s：
 *        3
 *       / \
 *      4   5
 *     / \
 *    1   2
 *       /
 *      0
 * 给定的树 t：
 *      4
 *     / \
 *    1   2
 * 返回 false。
 * @author Moonlight
 * @date 2021/5/8 14:51
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);
        root.right = new TreeNode(5);

        TreeNode sub = new TreeNode(4);
        sub.left = new TreeNode(1);
        sub.right = new TreeNode(2);

        System.out.println(isSubtree(root, sub));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private static boolean dfs(TreeNode root, TreeNode subRoot) {
        return root != null && (validate(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot));
    }

    private static boolean validate(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return validate(root.left, subRoot.left) && validate(root.right, subRoot.right);
    }

}