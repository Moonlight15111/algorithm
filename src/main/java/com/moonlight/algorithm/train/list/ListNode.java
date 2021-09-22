package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/6/17 10:00
 */
public class ListNode {
    public int val;
    public ListNode next;

    public  ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public  ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
