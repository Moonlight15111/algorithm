package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 链表实现栈
 * @author Moonlight
 * @date 2020/12/28 13:07
 */
public class ListImplementStack {

    private ListNode first;
    private int size;

    public boolean isEmpty() { return size == 0; }

    public int size() { return size; }

    public void push(int val) {
        ListNode oldFirst = first;
        first = new ListNode(val);
        first.next = oldFirst;
        size++;
    }

    public int pop() {
        ListNode res = first;
        first = first.next;
        size--;
        return res.val;
    }

}
