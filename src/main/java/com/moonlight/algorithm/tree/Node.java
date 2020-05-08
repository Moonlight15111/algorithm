package com.moonlight.algorithm.tree;


/**
 * @ClassName Node
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/6 22:05
 * @Version V1.0
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node (int val) {
        this.val = val;
    }

    public static Node getTree(){
        Node head = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);
        Node right2 = new Node(5);
        Node left3 = new Node(6);
        Node right3 = new Node(7);
        Node left4 = new Node(8);
        Node right4 = new Node(9);

        head.left = left1;
        head.right = right1;

        left1.left = left2;
        left1.right = right2;

        right1.left = left3;
        right1.right = right3;

        left2.left = left4;
        left2.right = right4;

        return head;
    }

    public static Node getTreeHaveParentNode(){
        Node head = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left2 = new Node(4);
        Node right2 = new Node(5);
        Node left3 = new Node(6);
        Node right3 = new Node(7);

        head.parent = null;
        head.left = left1;
        head.right = right1;

        left1.parent = head;
        left1.left = left2;
        left1.right = right2;

        right1.parent = head;
        right1.left = left3;
        right1.right = right3;

        return head;
    }

}
