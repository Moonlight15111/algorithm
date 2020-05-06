package com.moonlight.algorithm.tree;

import java.util.Stack;

/**
 * @ClassName BinaryTree
 * @Description: 头左右，左头右，左右头
 * @Author Moonlight
 * @Date 2020/5/6 22:05
 * @Version V1.0
 **/
public class BinaryTree {

    public static void main (String[] args) {
        preNonRecursive(Node.getTree());
        System.out.println("           ");
        preNonRecursive(Node.getTree());
        System.out.println("           ");

        inorderTraversal(Node.getTree());
        System.out.println("           ");
        inorderTraversalNonRecursive(Node.getTree());
        System.out.println("           ");

        postTraversal(Node.getTree());
        System.out.println("           ");
        postTraversalNonRecursive(Node.getTree());
        System.out.println("           ");
        postTraversalNonRecursiveLowSpace(Node.getTree());
    }

    public static void preTraversal(Node head){
        if (head == null) {
            return;
        }
        System.out.println("node val：" + head.val);
        preTraversal(head.left);
        preTraversal(head.right);
    }

    /**
     * @Author Moonlight
     * @Description 先序遍历，非递归实现。
     *              利用栈的先进后出特性，先压右孩子入栈，再压左孩子入栈，
     *              然后左孩子出栈，打印。循环上述过程。
     * @Date 2020/5/6 22:25
     * @Param 
     * @Exception 
     * @return 
     * @version 
     **/
    public static void preNonRecursive(Node head){
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println("node val：" + head.val);
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }
    }

    public static void inorderTraversal(Node head){
        if (head == null) {
            return;
        }
        inorderTraversal(head.left);
        System.out.println("node val：" + head.val);
        inorderTraversal(head.right);
    }

    /**
     * @Author Moonlight
     * @Description 中序遍历，非递归。
     *              先头节点入栈，然后head指向左孩子，此时如果head为空即没有左孩子
     *              那么就直接弹栈，打印，head指向右孩子。
     * @Date 2020/5/6 23:51
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static void inorderTraversalNonRecursive(Node head){
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println("node val：" + head.val);
                head = head.right;
            }
        }
    }


    public static void postTraversal(Node head){
        if (head == null) {
            return;
        }
        postTraversal(head.left);
        postTraversal(head.right);
        System.out.println("node val：" + head.val);
    }

    /**
     * @Author Moonlight
     * @Description 后序，非递归。大体思想和先序差不多，只不过多使用了一个栈。
     *              一个栈tStack用于遍历树，一个栈nStack用于记录节点顺序用于后续的打印
     *              头节点先入tStack，然后从中弹出压入nStack，然后如果有孩子节点就尝试往tStack压入左孩子，右孩子
     *              右孩子出栈，head指向右孩子，压入nStack。
     * @Date 2020/5/6 23:56
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static void postTraversalNonRecursive(Node head){
        if (head == null) {
            return;
        }
        Stack<Node> traversalStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();

        traversalStack.add(head);
        while(!traversalStack.isEmpty()) {
            head = traversalStack.pop();
            nodeStack.add(head);
            if (head.left != null) {
                traversalStack.add(head.left);
            }
            if (head.right != null) {
                traversalStack.add(head.right);
            }
        }

        while (!nodeStack.isEmpty()) {
            System.out.println("node val：" + nodeStack.pop().val);
        }
    }

    /**
     * @Author Moonlight
     * @Description 更低空间复杂度的非递归后序。用一个指针current记录当前所处的节点，一个指针head记录上次处理的节点
     *              current指针不停地往左孩子遍历并将其入栈，到左叶子节点后，打印此叶子节点，head指向此叶子节点
     *              current指针指向栈顶元素即左叶子节点的父节点，此时发现右叶子节点还未处理，于是current来到右叶子节点。
     * @Date 2020/5/7 0:07
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static void postTraversalNonRecursiveLowSpace(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node current = null;

        nodeStack.add(head);
        while (!nodeStack.isEmpty()) {
            current = nodeStack.peek();
            // 左孩子入栈
            if (current.left != null && head != current.left && head != current.right) {
                nodeStack.add(current.left);
            // 右孩子入栈
            } else if (current.right != null && head != current.right) {
                nodeStack.add(current.right);
            } else {
                // 左右孩子都已经处理完了(没有左右孩子也可以视作左右孩子都处理完了)，就直接出栈打印，head记录被处理的节点
                System.out.println("node val：" + nodeStack.pop().val);
                head = current;
            }
        }
    }

}
