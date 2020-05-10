package com.moonlight.algorithm.tree;

/**
 * @ClassName MaxBinarySearchTree
 * @Description: 求二叉树中最大的二叉搜索子树的大小。分为两种情况：
 *               一.和根节点root有关：则root的左右子树必定为搜索二叉树，且root必定要大于左子树的最大值，小于右子树的最小值
 *               二.和根节点root无关：则为左子树上满足二叉搜索子树的大小(节点数量) 或右子树上满足二叉搜索子树的大小(节点数量)
 * @Author Moonlight
 * @Date 2020/5/9 21:55
 * @Version V1.0
 **/
public class MaxBinarySearchTree {

    public static void main (String[] args) {
        Info info = findMaxBinarySearchTree(Node.getTree());
        System.out.println(info == null ? null : info.maxSubBinarySearchTreeSize);
    }

    public static Info findMaxBinarySearchTree (Node root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = findMaxBinarySearchTree(root.left);
        Info rightInfo = findMaxBinarySearchTree(root.right);

        boolean isBinarySearchTree = false;
        int maxSubBinarySearchTreeSize = 0, nodeMinVal = root.val, nodeMaxVal = root.val;

        if (leftInfo != null) {
            nodeMinVal = Math.min(nodeMinVal, leftInfo.nodeMinVal);
            nodeMaxVal = Math.max(nodeMaxVal, leftInfo.nodeMaxVal);
            maxSubBinarySearchTreeSize = Math.max(leftInfo.maxSubBinarySearchTreeSize, rightInfo.maxSubBinarySearchTreeSize);
        }

        if (rightInfo != null) {
            nodeMinVal = Math.min(nodeMinVal, rightInfo.nodeMinVal);
            nodeMaxVal = Math.max(nodeMaxVal, rightInfo.nodeMaxVal);
            maxSubBinarySearchTreeSize = Math.max(maxSubBinarySearchTreeSize, rightInfo.maxSubBinarySearchTreeSize);
        }

        boolean leftTreeIsBST = leftInfo == null || leftInfo.isBinarySearchTree;
        boolean rightTreeIsBST = rightInfo == null || rightInfo.isBinarySearchTree;
        boolean rootVal = leftInfo == null && rightInfo == null || leftInfo != null && leftInfo.nodeMaxVal < root.val && rightInfo.nodeMinVal > root.val;
        if (leftTreeIsBST && rightTreeIsBST && rootVal) {
            isBinarySearchTree = true;
            maxSubBinarySearchTreeSize = (leftInfo == null ? 0 : leftInfo.maxSubBinarySearchTreeSize) + (rightInfo == null ? 0 : rightInfo.maxSubBinarySearchTreeSize) + 1;
        }

        return new Info(isBinarySearchTree, maxSubBinarySearchTreeSize, nodeMinVal, nodeMaxVal);
    }


    static class Info{
        // 是否为搜索二叉树
        public boolean isBinarySearchTree;
        // 二叉搜索子树的最大个数
        public int maxSubBinarySearchTreeSize;
        // 节点最小值
        public int nodeMinVal;
        // 节点最大值
        public int nodeMaxVal;

        public Info (boolean isBinarySearchTree, int maxSubBinarySearchTreeSize, int nodeMinVal, int nodeMaxVal) {
            this.isBinarySearchTree = isBinarySearchTree;
            this.maxSubBinarySearchTreeSize = maxSubBinarySearchTreeSize;
            this.nodeMinVal = nodeMinVal;
            this.nodeMaxVal = nodeMaxVal;
        }
    }

}
