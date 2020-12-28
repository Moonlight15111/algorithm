package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/28 13:17
 */
public class ListImplementBag {

    private ListNode first;

    public void add(int val) {
        ListNode oldFirst = first;
        first = new ListNode(val);
        first.next = oldFirst;
    }

}
