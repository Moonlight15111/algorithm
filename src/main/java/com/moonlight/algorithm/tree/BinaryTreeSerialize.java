package com.moonlight.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName BinaryTreeSerialize
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/7 21:51
 * @Version V1.0
 **/
public class BinaryTreeSerialize {

    public static void main (String[] args) {
        Queue<Integer> queue = preSerialize(Node.getTree());
        for (Integer val : queue) {
            System.out.print(val + ", ");
        }
        System.out.println("           ");

        queue = inSerialize(Node.getTree());
        for (Integer val : queue) {
            System.out.print(val + ", ");
        }
        System.out.println("           ");

        queue = postSerialize(Node.getTree());
        for (Integer val : queue) {
            System.out.print(val + ", ");
        }
        System.out.println("           ");

        queue = widthSerialize(Node.getTree());
        for (Integer val : queue) {
            System.out.print(val + ", ");
        }
        System.out.println("           ");
    }

    public static Queue<Integer> preSerialize (Node root) {
        Queue<Integer> queue = new LinkedList<>();
        if (root == null) {
            return queue;
        }
        pre(root, queue);

        return queue;
    }

    private static void pre(Node root, Queue<Integer> queue) {
        if (root == null) {
            queue.add(null);
            return;
        }
        queue.add(root.val);
        pre(root.left, queue);
        pre(root.right, queue);
    }

    public static Queue<Integer> inSerialize (Node root) {
        Queue<Integer> queue = new LinkedList<>();
        if (root == null) {
            return queue;
        }
        in(root, queue);

        return queue;
    }

    private static void in(Node root, Queue<Integer> queue) {
        if (root == null) {
            queue.add(null);
            return;
        }
        pre(root.left, queue);
        queue.add(root.val);
        pre(root.right, queue);
    }

    public static Queue<Integer> postSerialize (Node root) {
        Queue<Integer> queue = new LinkedList<>();
        if (root == null) {
            return queue;
        }
        post(root, queue);

        return queue;
    }

    private static void post(Node root, Queue<Integer> queue) {
        if (root == null) {
            queue.add(null);
            return;
        }
        pre(root.left, queue);
        pre(root.right, queue);
        queue.add(root.val);
    }

    public static Queue<Integer> widthSerialize (Node root) {
        Queue<Integer> data = new LinkedList<>();
        if (root == null) {
            return data;
        }
        Queue<Node> traversal = new LinkedList<>();
        traversal.add(root);
        data.add(root.val);

        while (!traversal.isEmpty()) {
            root = traversal.poll();
            if (root.left != null) {
                traversal.add(root.left);
                data.add(root.left.val);
            } else {
                data.add(null);
            }
            if (root.right != null) {
                traversal.add(root.right);
                data.add(root.right.val);
            } else {
                data.add(null);
            }
        }
        return data;
    }


}
