package com.moonlight.algorithm.linkedlist;

/**
 * @ClassName ChaseTravelList
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/5/5 21:56
 * @Version V1.0
 **/
public class IntersectionList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

//        node5.next = node3;
//        System.out.println(intersectionPoint(head).val);

        Node head11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);

        head11.next = node12;
        node12.next = node13;
        node13.next = node3;

        System.out.println(intersectionPoint(head, head11).val);
    }

    /**
     * @Author Moonlight
     * @Description 追及问题。快指针先走两步，慢指针先走一步，二者第一次相遇后，
     *              快指针回到起点一次走一步，慢指针继续一次走一步，第二次相遇的点即为入环点
     * @Date 2020/5/5 23:09
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static Node intersectionPoint(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next, fast = head.next.next;
        while (!fast.equals(slow)) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (!fast.equals(slow)) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * @Author Moonlight
     * @Description 先求出两个链表的长度差，短的等长的遍历到一个位置上以后(即二者长度没有差值了)和长的一起向下遍历
     * @Date 2020/5/5 23:06
     * @Param
     * @Exception
     * @return
     * @version
     **/
    public static Node intersectionPoint(Node head1, Node head2){
        if (head1 == null || head2 == null) {
            return null;
        }
        Node current1 = head1, current2 = head2;
        int length = 0;
        while (current1.next != null) {
            length++;
            current1 = current1.next;
        }
        while (current2.next != null) {
            length--;
            current2 = current2.next;
        }

        if (!current1.equals(current2)) {
            return null;
        }

        current1 = length > 0 ? head1 : head2;
        current2 = current1.equals(head1) ? head2 : head1;

        length = Math.abs(length);

        while (length != 0) {
            length--;
            current1 = current1.next;
        }
        while (!current1.equals(current2)) {
            current1 = current1.next;
            current2 =current2.next;
        }
        return current1;
    }


    static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
