package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 输入：A = [1,2,3], B = [3,1]  输出：false
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]  输出：true
 *
 */
public class IsSubStructure {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(-2);
        a.left = new TreeNode(1);
        a.right = new TreeNode(-1);

        TreeNode b = new TreeNode(-2);
        b.left = new TreeNode(1);
        b.right = new TreeNode(1);

        System.out.println(isSubStructure(a, b));

        a = new TreeNode(10);
        a.left = new TreeNode(12);
        a.left.left = new TreeNode(8);
        a.left.right = new TreeNode(3);
        a.right = new TreeNode(6);
        a.right.left = new TreeNode(11);

        b = new TreeNode(10);
        b.left = new TreeNode(12);
        b.left.left = new TreeNode(8);
        b.right = new TreeNode(6);

        System.out.println(isSubStructure(a, b));
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return A != null && B != null && (check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private static boolean check(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }

}
