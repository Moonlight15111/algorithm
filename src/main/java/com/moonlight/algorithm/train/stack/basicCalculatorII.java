package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/basic-calculator-ii/
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。整数除法仅保留整数部分。
 *
 * 输入：s = "3+2*2"  输出：7
 *
 * 输入：s = " 3/2 "  输出：1
 *
 * 输入：s = " 3+5 / 2 "  输出：5
 *
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 *
 * @author Moonlight
 * @date 2021/3/11 12:09
 */
public class basicCalculatorII {

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3/2"));
        System.out.println(calculate(" 3+5 / 2 "));
    }

    public static int calculate(String s) {
        int num = 0;
        char c, preop = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            c = s.charAt(i);
            if (isNum(c)) {
                num = 10 * num + c - '0';
            }
            if (!isNum(c) && c != ' ' || i == len - 1) {
                switch (preop) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(- num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                preop = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

}
