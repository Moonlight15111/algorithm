package com.moonlight.algorithm.linkedlist;

import com.moonlight.algorithm.train.ListNode;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 删除倒数的第K个节点
 * 倒数的第K个，即第 链表长度 - K + 1 结点，它的前一个结点即为 链表长度 - K
 * 链表从前往后走，K自减，到链表结尾  =>  K - 链表长度
 * 如果 K == 0 即 K 与 链表长度相等，说明要删除的是头结点，则直接返回 head.next
 * 如果 K > 0 即 K 超出了链表长度，说明根本没有倒数第K个节点，则直接返回 head
 * 如果 K < 0 即 K 小于链表长度，此时需要做的就是找到 倒数第 K 个 结点的前一个结点
 * 重新从链表头往尾走，K自增，当 K == 0 时，此时所在的结点就是倒数第 K 个节点的前一个结点 => cur 从头往尾走了 链表长度 - K 步 ，可以看做 | K - 链表长度 |
 * @author Moonlight
 * @date 2020/11/20 16:31
 */
public class RemoveLastKthNode {

    public static void main(String[] args) {
        SingleNode head = new SingleNode(1);
        head.next = new SingleNode(2);
        head.next.next = new SingleNode(3);
        head.next.next.next = new SingleNode(4);
        head.next.next.next.next = new SingleNode(5);
        head.next.next.next.next.next = new SingleNode(6);

        SingleNode newHead = removeLastKthSingleNodeOneLoop(head, 8);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }

        System.out.println("----------------------------------------------");

        DoubleNode doubleHead = new DoubleNode(1);
        doubleHead.next = new DoubleNode(2);
        doubleHead.next.next = new DoubleNode(3);
        doubleHead.next.next.next = new DoubleNode(4);
        doubleHead.next.next.next.next = new DoubleNode(5);
        doubleHead.next.next.next.next.next = new DoubleNode(6);

        DoubleNode doubleNewHead = removeLastKthDoubleNode(doubleHead, 2);
        while (doubleNewHead != null) {
            System.out.println(doubleNewHead.val);
            doubleNewHead = doubleNewHead.next;
        }
    }

    public static SingleNode removeLastKthSingleNodeOneLoop(SingleNode head, int lastKth) {
        if (head == null || head.next == null || lastKth < 1) {
            return head;
        }

        SingleNode fast = head, slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (lastKth == 0) {
                slow = slow.next;
            } else {
                lastKth--;
            }
        }
        if (lastKth != 0) {
            return head;
        } else {
            slow.next = slow.next.next;
        }
        return head;

    }

    public static SingleNode removeLastKthSingleNode(SingleNode head, int lastKth) {
        if (head == null || head.next == null || lastKth < 1) {
            return head;
        }
        SingleNode cur = head;

        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            return head.next;
        } else if (lastKth > 0) {
            return head;
        } else {
            cur = head;
            while (++lastKth < 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
        if (head == null || head.next == null || lastKth < 1) {
            return head;
        }
        DoubleNode cur = head;

        while (cur.next != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            return head.next;
        } else if (lastKth > 0) {
            return head;
        } else {
            cur = head;
            while (lastKth < 0) {
                lastKth++;
                cur = cur.next;
            }
            cur.next = cur.next.next;
            cur.next.prev = cur;
        }
        return head;
    }

    private static class SingleNode {
        int val;
        SingleNode next;

        public SingleNode (int val) {
            this.val = val;
        }
    }

    private static class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode prev;

        public DoubleNode (int val) {
            this.val = val;
        }
    }
}
