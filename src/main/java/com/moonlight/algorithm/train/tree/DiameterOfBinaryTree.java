package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 *
 * 输入:            1
 *                /  \
 *               2   3
 *              / \
 *             4   5
 * 输出: 3,  它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @author Moonlight
 * @date 2021/5/8 10:27
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(3);
        r.left.right = new TreeNode(4);
        r.left.right.left = new TreeNode(5);
        r.left.right.right = new TreeNode(6);
        r.left.right.left.left = new TreeNode(7);

        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree(r));
    }

    static int ans = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        // 某个节点的左子树的最大深度 + 右子树的最大深度 == 树的直径长度
        dep(root);
        return ans;
    }

    private static int dep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dep(root.left);
        int r = dep(root.right);
        ans = Math.max(ans, l + r);
        return Math.max(l, r) + 1;
    }

}
