package com.moonlight.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 根据一个栈对另一个栈进行排序
 * @author Moonlight
 * @date 2020/11/20 11:31
 */
public class SortStackByStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println(Arrays.toString(stack.toArray()));

        sortStackByStack(stack);

        System.out.println(Arrays.toString(stack.toArray()));
    }

    public static void sortStackByStack(Stack<Integer> sortStack) {
        Stack<Integer> help = new Stack<>();

        while (!sortStack.isEmpty()) {
            int cur = sortStack.pop();
            // 如果help 栈是空的 或者 cur >= help 栈顶元素  直接塞到help栈里面
            if (help.isEmpty() || cur >= help.peek()) {
                help.push(cur);
            } else if (cur < help.peek()) {
                // 如果help 栈顶元素是要大于当前的元素，那么就需要重新进行排序
                // 两种方式：一、直接全部重排  二、找到不再小于当前元素的位置，然后再此处进行重排

                int pop = help.pop();
                sortStack.push(pop);
                while (!help.isEmpty() && cur < pop) {
                    pop = help.pop();
                    sortStack.push(pop);
                }
//                while (!help.isEmpty()) {
//                    sortStack.push(help.pop());
//                }

                help.push(cur);
            }
        }

        while (!help.isEmpty()) {
            sortStack.push(help.pop());
        }
    }

}
