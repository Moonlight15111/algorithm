package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/28 13:11
 */
public class ListImplementQueue {

    private ListNode first;
    private ListNode last;
    private int size;

    public void enqueue(int val) {
        ListNode oldLast = last;
        last = new ListNode(val);
        if (size == 0) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public int dequeue() {
        ListNode res = first;
        first = first.next;
        if (size == 0) {
            last = null;
        }
        size--;
        return res.val;
    }

}
