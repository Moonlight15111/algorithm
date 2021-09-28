package com.moonlight.algorithm.train.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * 给定一个二叉树
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 进阶：
 *   你只能使用常量级额外空间。
 *   使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
 *
 */
public class ConnectII {

    public static void main(String[] args) {
        Node r = new Node(1);

        r.left = new Node(2);
        r.left.left = new Node(4);
        r.left.right = new Node(5);

        r.right = new Node(3);
        r.right.right = new Node(7);

        r = connect(r);
        System.out.println(p(r));;
    }

    private static String p(Node r) {
        Queue<Node> q = new LinkedList<>();
        q.add(r);
        Node cur;
        StringBuilder a = new StringBuilder();
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                cur = q.poll();
                a.append(cur.val).append(", ");
                if (cur.next == null) {
                    a.append("#, ");
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return a.toString();
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        Node c = root;
        q.add(c);
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                c = q.poll();
                if (i < s - 1) {
                    c.next = q.peek();
                }
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }
            }
        }
        return root;
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
