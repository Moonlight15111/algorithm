package com.moonlight.algorithm.train.tree;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * 输入:
 * Tree 1                     Tree 2
 *     1                         2
 *    / \                       / \
 *   3   2                     1   3
 *  /                           \   \
 * 5                             4   7
 * 输出: 合并后的树:
 *      3
 *     / \
 *    4   5
 *   / \   \
 * 5   4   7
 *
 * @author Moonlight
 * @date 2021/5/10 12:47
 */
public class MergeTrees {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(3);
        r1.left.left = new TreeNode(5);
        r1.right = new TreeNode(2);

        TreeNode r2 = new TreeNode(2);
        r2.left = new TreeNode(1);
        r2.left.right = new TreeNode(4);
        r2.right = new TreeNode(3);
        r2.right.right = new TreeNode(7);

        TreeNode node = mergeTrees(r1, r2);
        print(node);
    }

    public static void print(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + ", ");
            print(node.left);
            print(node.right);
        }
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null || root2 == null) {
            return root1 == null ? root2 : root1;
        }
        TreeNode ans = new TreeNode(root1.val + root2.val);

        ans.left = mergeTrees(root1.left, root2.left);
        ans.right = mergeTrees(root1.right, root2.right);

        return ans;
    }

}
