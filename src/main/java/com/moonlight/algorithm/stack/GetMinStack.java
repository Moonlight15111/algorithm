package com.moonlight.algorithm.stack;

import java.util.Stack;

/**
 * @ClassName GetMinStack
 * @Description: 獲取棧中最小的數
 * @Author Moonlight
 * @Date 2020/5/3 0:51
 * @Version V1.0
 **/
public class GetMinStack {

    public static void main(String[] args){
        GetMinStack stack = new GetMinStack();
        stack.push(8).push(7).push(4).push(4).push(1).push(9);
        System.out.println(stack.getMin());
    }

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public GetMinStack push(Integer num) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(num);
        } else if (num <= getMin()) {
            this.minStack.push(num);
        } else {
            this.minStack.push(getMin());
        }
        this.dataStack.push(num);
        return this;
    }

    public Integer pop() {
        if (this.dataStack.isEmpty()) {
            throw new RuntimeException("current stack is empty");
        }
        this.minStack.pop();
        return this.dataStack.pop();
    }

    public Integer getMin() {
        return this.minStack.peek();
    }

}
