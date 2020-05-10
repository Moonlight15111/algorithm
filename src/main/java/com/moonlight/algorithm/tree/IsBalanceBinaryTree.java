package com.moonlight.algorithm.tree;

/**
 * @ClassName BalanceBinaryTree
 * @Description: 求是否为平衡二叉树。根据平衡二叉树定义: 每颗子树的高度差不超过 1
 *               可知：根节点为root的树，其左子树必为平衡树，右子树也必为平衡树，且左右子树高度差不超过 1
 * @Author Moonlight
 * @Date 2020/5/8 22:19
 * @Version V1.0
 **/
public class IsBalanceBinaryTree {

    public static void main(String[] args){
        System.out.println(isBalanceBinaryTree(Node.getTree()));
        System.out.println(isBalanceBinaryTree(Node.getTreeHaveParentNode()));
    }

    public static boolean isBalanceBinaryTree(Node root){
        return treeInfo(root).isBalance;
    }

    private static Info treeInfo(Node root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info leftInfo = treeInfo(root.left);
        Info rightInfo = treeInfo(root.right);
        int treeHeight = Math.max(leftInfo.height, rightInfo.height) + 1;
        if (!leftInfo.isBalance || !rightInfo.isBalance || Math.abs(leftInfo.height - rightInfo.height) > 1) {
            return new Info(false, treeHeight);
        }
        return new Info(true, treeHeight);
    }


    static class Info {
        private boolean isBalance;
        private int height;

        public Info (boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
}
