package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/submissions/
 *       https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @author Moonlight
 * @date 2020/12/25 10:15
 */
public class TwoStackQueue {
    private Stack<Integer> head;
    private Stack<Integer> tail;

    public TwoStackQueue() {
        head = new Stack<>();
        tail = new Stack<>();
    }

    private void trans() {
        while (head.isEmpty()) {
            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }
    }

    public void appendTail(int value) {
        tail.push(value);
        trans();
    }

    public int deleteHead() {
        if (head.isEmpty() && tail.isEmpty()) {
            return -1;
        }
        trans();
        return head.pop();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        head.push(x);
        trans();
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        trans();
        return tail.pop();
    }

    /** Get the front element. */
    public int peek() {
        trans();
        return tail.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return head.isEmpty() && tail.isEmpty();
    }


    public static class SingleStackQueue {
        private Stack<Integer> stack;

        public SingleStackQueue() {
            stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (stack.isEmpty()) {
                return -1;
            }
            Integer firstElement = stack.firstElement();
            stack.removeElementAt(0);
            return firstElement;
        }

        /** Get the front element. */
        public int peek() {
            if (stack.isEmpty()) {
                return -1;
            }
            return stack.elementAt(0);
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();
        }

    }
}
