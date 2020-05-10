package com.moonlight.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName IsCBT
 * @Description: 1.没有左孩子只有右孩子则不为完全二叉树
 *               2.如果遇见有缺失右孩子或左右孩子都为空的结点，那么它后续的所有结点都必须为叶子结点
 * @Author Moonlight
 * @Date 2020/5/10 13:22
 * @Version V1.0
 **/
public class IsCBT {

    public static void main (String[] args) {
        System.out.println(isCBT(Node.getTree()));
        System.out.println(isCBT2(Node.getTree()));
    }

    public static boolean isCBT(Node root){
        if (root == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<>();

        // 是否遇见孩子不完整的结点
        boolean childrenIncomplete = false;

        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            if ((childrenIncomplete && !(root.left == null && root.right == null)) || (root.left == null && root.right != null)) {
                return false;
            }
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left == null || root.right == null) {
                childrenIncomplete = true;
            }
        }
        return true;
    }

    public static boolean isCBT2(Node root){
        return findIsCBT(root).isCBT;
    }

    private static Info findIsCBT(Node root) {
        if (root == null) {
            return new Info(true, true, 0);
        }

        Info leftInfo = findIsCBT(root.left);
        Info rightInfo = findIsCBT(root.right);

        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
        boolean isCBT = false;

        if (isFull) {
            isCBT = true;
        } else {
            if (leftInfo.isCBT && rightInfo.isCBT) {
                // 左右都为满二叉树，且左子树比右子树高一层，说明左子树满了，但还没蔓延到右子树上
                if (leftInfo.isFull && rightInfo.isFull && leftInfo.height - 1 == rightInfo.height) {
                    isCBT = true;
                }
                // 左子树为满二叉树 且左右子树高度一致，说明左子树已经满了且蔓延到了右子树
                if (leftInfo.isFull && leftInfo.height == rightInfo.height) {
                    isCBT = true;
                }
                // 右子树为满二叉树，且左子树比右子树高一层，说明左子树还没满
                if (rightInfo.isFull && leftInfo.height - 1 == rightInfo.height) {
                    isCBT = true;
                }
            }
        }

        return new Info(isFull, isCBT, height);
    }

    static class Info {
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info (boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT  = isCBT;
            this.height = height;
        }
    }

}
