package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 *
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 *
 * 根据 逆波兰表示法，求表达式的值。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 * 说明：
 *     整数除法只保留整数部分。
 *     给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 * 输入：tokens = ["2","1","+","3","*"]    输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 *
 * 输入：tokens = ["4","13","5","/","+"]   输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]    输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 *         ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *         = ((10 * (6 / (12 * -11))) + 17) + 5
 *         = ((10 * (6 / -132)) + 17) + 5
 *         = ((10 * 0) + 17) + 5
 *         = (0 + 17) + 5
 *         = 17 + 5
 *         = 22
 *
 * @author Moonlight
 * @date 2021/3/20 9:20
 */
public class EvalRPN {

    public static void main(String[] args) {
        String[] a = {"2","1","+","3","*"},
                b = {"4","13","5","/","+"},
                c = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(a));
        System.out.println(evalRPN(b));
        System.out.println(evalRPN(c));
    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        Integer a, b;
        for (String token : tokens) {
            if (isOpCode(token)) {
                a = operands.pop();
                b = operands.pop();
                switch (token) {
                    case "+":
                        operands.push(a + b);
                        break;
                    case "-":
                        operands.push(b - a);
                        break;
                    case "*":
                        operands.push(a * b);
                        break;
                    default:
                        operands.push(b / a);
                        break;
                }
            } else {
                operands.push(Integer.valueOf(token));
            }
        }
        return operands.pop();
    }

    public static boolean isOpCode(String s) {
        return "+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s);
    }

}
