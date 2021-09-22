package com.moonlight.algorithm.train.design;
import com.moonlight.algorithm.train.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/linked-list-random-node
 *
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * 进阶: 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 *
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 *
 */
public class RandomNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        RandomNode solution = new RandomNode(head);

        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
        System.out.println(solution.getRandom());
    }

    private List<Integer> list;
    private Random random;

    public RandomNode(ListNode head) {
        list = new ArrayList<>();
        random = new Random();

        ListNode t = head;
        while (t != null) {
            list.add(t.val);
            t = t.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }


}