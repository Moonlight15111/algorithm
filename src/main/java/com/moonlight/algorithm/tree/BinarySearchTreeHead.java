package com.moonlight.algorithm.tree;

/**
 * @ClassName BinarySearchTreeHead
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/10 2:29
 * @Version V1.0
 **/
public class BinarySearchTreeHead {

    public static void main (String[] args) {
        Node head = binarySearchTreeHead(Node.getTree());
        System.out.println(head == null ? null : head.val);
    }

    public static Node binarySearchTreeHead (Node root) {
        Info info = findHead(root);
        return info == null ? null : info.headNode;
    }

    private static Info findHead(Node root) {
        if (root == null) {
            return null;
        }
        Info leftInfo = findHead(root.left);
        Info rightInfo = findHead(root.right);

        int size = 0, min = root.val, max = root.val;
        Node head = null;

        if (leftInfo != null) {
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            size = leftInfo.size;
            head = leftInfo.headNode;
        }
        if (rightInfo != null) {
            min = Math.min(min, rightInfo.min);
            max = Math.max(max, rightInfo.max);
            if (rightInfo.size > size) {
                size = rightInfo.size;
                head = rightInfo.headNode;
            }
        }

        boolean leftTreeIsBST = leftInfo == null || (leftInfo.headNode == root.left && leftInfo.max < root.val);
        boolean rightTreeIsBST = rightInfo == null || (rightInfo.headNode == root.right && rightInfo.min > root.val);

        if (leftTreeIsBST && rightTreeIsBST) {
            head = root;
            size = (leftInfo == null ? 0 : leftInfo.size) + (rightInfo == null ? 0 : rightInfo.size) + 1;
        }
        return new Info(size, max, min, head);
    }

    static class Info {
        public int size, max, min;
        public Node headNode;

        public Info (int size, int max, int min, Node headNode) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.headNode = headNode;
        }
    }

}
