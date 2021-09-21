package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 请使用递归函数逆序一个栈，请注意：只能使用递归函数，不能借助其他数据结构
 *
 * @ClassName ReverseStack
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/9/21 13:11
 * @Version V1.0
 **/
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(2);
        stack.add(1);

        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int r = reverse(stack);
        reverseStack(stack);
        stack.push(r);
    }

    private static int reverse(Stack<Integer> stack) {
        Integer pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            int b = reverse(stack);
            stack.push(pop);
            return b;
        }
    }

}
