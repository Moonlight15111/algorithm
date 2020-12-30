package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/30 17:17
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node() {}
    public Node(int val) {
        this.val = val;
    }
}
