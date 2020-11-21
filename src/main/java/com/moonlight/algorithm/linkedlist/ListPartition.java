package com.moonlight.algorithm.linkedlist;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个单向链表头结点head，再给定一个整数pivot，实现一个调整函数
 * 小于pivot在左边 等于pivot在中间 大于pivot在右边
 * @author Moonlight
 * @date 2020/11/21 12:20
 */
public class ListPartition {

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(4);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(3);

        head = listPartition(head, 4);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node listPartition(Node head, int pivot) {
        if (head == null) {
            return null;
        }
        // 1.分成三块区域: 小于   等于    大于
        Node lH = null, lT = null;
        Node eH = null, eT = null;
        Node gH = null, gT = null;

        Node cur = head;
        Node next;
        while (cur != null) {
            // 需要先断掉之前的联系
            next = cur.next;
            cur.next = null;
            if (cur.val > pivot) {
                // 头为null  表示还没有数据，同一起点出发
                if (gH == null) {
                    gH = cur;
                    gT = cur;
                } else {
                    // 旧尾巴的下一个为新尾巴，gT指针指向新尾巴
                    gT.next = cur;
                    gT = cur;
                }
            }
            if (cur.val == pivot) {
                if (eH == null) {
                    eH = cur;
                    eT = cur;
                } else {
                    eT.next = cur;
                    eT = cur;
                }
            }
            if (cur.val < pivot) {
                if (lH == null) {
                    lH = cur;
                    lT = cur;
                } else {
                    lT.next = cur;
                    lT = cur;
                }
            }
            cur = next;
        }

        if (lT != null) {
            lT.next = eH;
            eT = eT == null ? lT : eT;
        }

        if (eT != null) {
            eT.next = gH;
        }

        return lH != null ? lH : eH != null ? eH : gH ;
    }


    private static class Node {
        int val;
        Node next;
        public Node(int val) { this.val = val;}
    }

}
