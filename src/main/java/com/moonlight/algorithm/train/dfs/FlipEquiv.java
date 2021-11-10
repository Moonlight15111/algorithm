package com.moonlight.algorithm.train.dfs;

/**
 * https://leetcode-cn.com/problems/flip-equivalent-binary-trees/
 *
 * 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 *
 * 输入：root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * 输出：true
 *
 * @author Moonlight
 */
public class FlipEquiv {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1), b = new TreeNode(1);
        a.left = new TreeNode(2);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.left.right.left = new TreeNode(7);
        a.left.right.right = new TreeNode(8);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(6);

        b.left = new TreeNode(3);
        b.left.right = new TreeNode(6);
        b.right = new TreeNode(2);
        b.right.left = new TreeNode(4);
        b.right.right = new TreeNode(5);
        b.right.right.left = new TreeNode(8);
        b.right.right.right = new TreeNode(7);

        System.out.println(flipEquiv(a, b));
    }

    public static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                ||
               (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

}
