package com.moonlight.algorithm.tree;

/**
 * @ClassName IsFullBinaryTree
 * @Description: 求是否为满二叉树。满二叉树满足：高度为 H，结点数为 N，则(2 ** H) - 1 == N
 * @Author Moonlight
 * @Date 2020/5/10 0:24
 * @Version V1.0
 **/
public class IsFullBinaryTree {

    public static void main (String[] args) {
        System.out.println(isFullBinaryTree(Node.getTree()));
    }

    public static boolean isFullBinaryTree (Node root) {
        Info info = findFullBinaryTree(root);
//        return Math.pow(2, info.height) - 1 == info.nodeSize;
        return (1 << info.height) - 1 == info.nodeSize;
    }

    public static Info findFullBinaryTree (Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info leftInfo = findFullBinaryTree(root.left);
        Info rightInfo = findFullBinaryTree(root.right);
        return new Info(leftInfo.nodeSize + rightInfo.nodeSize + 1, Math.max(leftInfo.height, rightInfo.height) + 1);
    }


    static class Info {
        public int nodeSize, height;

        public Info (int nodeSize, int height) {
            this.nodeSize = nodeSize;
            this.height = height;
        }
    }
}
