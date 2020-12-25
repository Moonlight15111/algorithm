package com.moonlight.algorithm.train.list;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/25 11:09
 */
public class ReversePrintList {

    public int[] reversePrint2222(ListNode head) {
        int len = 0;
        int[] arr = new int[10000];
        int[] res;

        while (head != null) {
            arr[len++] = head.val;
            head = head.next;
        }

        res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = arr[len - i - 1];
        }

        return res;
    }

    public int[] reversePrint(ListNode head) {
        int len = 0;
        ListNode next, prev = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            len++;
        }
        int[] arr = new int[len];
        len = 0;
        while (prev != null) {
            arr[len++] = prev.val;
            prev = prev.next;
        }
        return arr;
    }

}
