package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/submissions/
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
}
