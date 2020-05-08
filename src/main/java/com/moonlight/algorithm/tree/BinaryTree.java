package com.moonlight.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
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

        System.out.println("           ");
        breadthSearch(Node.getTree());
        System.out.println("           ");

    }

    public static void preTraversal(Node root){
        if (root == null) {
            return;
        }
        System.out.println("node val：" + root.val);
        preTraversal(root.left);
        preTraversal(root.right);
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
    public static void preNonRecursive(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println("node val：" + root.val);
            if (root.right != null) {
                stack.add(root.right);
            }
            if (root.left != null) {
                stack.add(root.left);
            }
        }
    }

    public static void inorderTraversal(Node root){
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.println("node val：" + root.val);
        inorderTraversal(root.right);
    }

    /**
     * @Author Moonlight
     * @Description 中序遍历，非递归。
     *              先头节点入栈，然后root指向左孩子，此时如果root为空即没有左孩子
     *              那么就直接弹栈，打印，root指向右孩子。
     * @Date 2020/5/6 23:51
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static void inorderTraversalNonRecursive(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println("node val：" + root.val);
                root = root.right;
            }
        }
    }


    public static void postTraversal(Node root){
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.println("node val：" + root.val);
    }

    /**
     * @Author Moonlight
     * @Description 后序，非递归。大体思想和先序差不多，只不过多使用了一个栈。
     *              一个栈tStack用于遍历树，一个栈nStack用于记录节点顺序用于后续的打印
     *              头节点先入tStack，然后从中弹出压入nStack，然后如果有孩子节点就尝试往tStack压入左孩子，右孩子
     *              右孩子出栈，root指向右孩子，压入nStack。
     * @Date 2020/5/6 23:56
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static void postTraversalNonRecursive(Node root){
        if (root == null) {
            return;
        }
        Stack<Node> traversalStack = new Stack<>();
        Stack<Node> nodeStack = new Stack<>();

        traversalStack.add(root);
        while(!traversalStack.isEmpty()) {
            root = traversalStack.pop();
            nodeStack.add(root);
            if (root.left != null) {
                traversalStack.add(root.left);
            }
            if (root.right != null) {
                traversalStack.add(root.right);
            }
        }

        while (!nodeStack.isEmpty()) {
            System.out.println("node val：" + nodeStack.pop().val);
        }
    }

    /**
     * @Author Moonlight
     * @Description 更低空间复杂度的非递归后序。用一个指针current记录当前所处的节点，一个指针root记录上次处理的节点
     *              current指针不停地往左孩子遍历并将其入栈，到左叶子节点后，打印此叶子节点，root指向此叶子节点
     *              current指针指向栈顶元素即左叶子节点的父节点，此时发现右叶子节点还未处理，于是current来到右叶子节点。
     * @Date 2020/5/7 0:07
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static void postTraversalNonRecursiveLowSpace(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        Node current = null;

        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            current = nodeStack.peek();
            // 左孩子入栈
            if (current.left != null && root != current.left && root != current.right) {
                nodeStack.add(current.left);
            // 右孩子入栈
            } else if (current.right != null && root != current.right) {
                nodeStack.add(current.right);
            } else {
                // 左右孩子都已经处理完了(没有左右孩子也可以视作左右孩子都处理完了)，就直接出栈打印，root记录被处理的节点
                System.out.println("node val：" + nodeStack.pop().val);
                root = current;
            }
        }
    }

    public static void breadthSearch(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println("node val：" + root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
    }

}
