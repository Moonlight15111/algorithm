package com.moonlight.algorithm.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 * 原题地址: https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
 * @author Moonlight
 * @date 2020/11/20 10:19
 */
public class TwoStacksQueue {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        translateData();
        return popStack.pop();
    }

    private void translateData() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException();
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
    }

    public int peek() {
        translateData();
        return popStack.peek();
    }

    public boolean empty() {
        translateData();
        return popStack.isEmpty();
    }

}
