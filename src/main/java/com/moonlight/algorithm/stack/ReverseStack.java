package com.moonlight.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 使用递归方式逆序一个栈
 * @author Moonlight
 * @date 2020/11/20 11:01
 */
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(Arrays.toString(stack.toArray()));

        reverse(stack);

        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLast(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLast(Stack<Integer> stack) {
        int res = stack.pop();
        if (stack.isEmpty()) {
            return res;
        }
        int last = getAndRemoveLast(stack);
        stack.push(res);
        return last;
    }

}
