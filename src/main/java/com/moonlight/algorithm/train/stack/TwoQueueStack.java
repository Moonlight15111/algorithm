package com.moonlight.algorithm.train.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * @author Moonlight
 * @date 2020/12/25 10:28
 */
public class TwoQueueStack {
    private Queue<Integer> head;
    private Queue<Integer> tail;

    /** Initialize your data structure here. */
    public TwoQueueStack() {
        head = new LinkedList<>();
        tail = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        head.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (head.size() > 1) {
            tail.add(head.poll());
        }
        int res = head.poll();
        Queue<Integer> tmp = head;
        head = tail;
        tail = tmp;
        return res;
    }

    /** Get the top element. */
    public int top() {
        while (head.size() > 1) {
            tail.add(head.poll());
        }
        int res = head.poll();
        tail.add(res);
        Queue<Integer> tmp = head;
        head = tail;
        tail = tmp;
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }
}
