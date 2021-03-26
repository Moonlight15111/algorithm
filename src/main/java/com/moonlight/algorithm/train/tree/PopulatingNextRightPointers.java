package com.moonlight.algorithm.train.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * struct Node {
 *     int val;
 *     Node *left;
 *     Node *right;
 *     Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *       序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *
 * @author Moonlight
 * @date 2021/3/26 13:12
 */
public class PopulatingNextRightPointers {

    public static void main() {

    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node tmp;
        int size;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                if (i < size - 1) {
                    tmp.next = queue.peek();
                }
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
        return root;
    }

    class Node {
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
