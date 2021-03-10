package com.moonlight.algorithm.train.stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/basic-calculator/
 * <p>
 * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
 * 提示：1. 1 <= s.length <= 3 * 105   2. s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * 3. s 表示一个有效的表达式
 * <p>
 * 输入：s = "1 + 1"   输出：2
 * 输入：s = " 2-1 + 2 "  输出：3
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"  输出：23
 *
 * @author Moonlight
 * @date 2021/3/10 9:17
 */
public class BasicCalculator {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("2-1 + 2"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("-2 + 1"));
        System.out.println(calculate("- (3 + (4 + 5))"));
        System.out.println(calculate("- (3 - (2 + 1 - (1 - 1)))"));

        // 不给过的
        ScriptEngine jsEngine = new ScriptEngineManager().getEngineByName("JavaScript");
        try {
            System.out.println((int)jsEngine.eval("(1+(4+5+2)-3)+(6+8)"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static int calculate(String s) {
        // 一个操作数栈，一个操作码栈，遇到 ) 括号就从操作数栈中弹两个操作数，从操作码栈中弹一个操作码
        // 计算完毕后，将结果再存入操作数栈
        // 操作数栈
        Stack<Integer> operandsStack = new Stack<>();
        // 操作码栈
        Stack<Character> opcodeStack = new Stack<>();
        char c;
        int num;
        for (int i = 0, len = s.length(); i < len; i++) {
            c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(' || c == '+' || c == '-') {
                opcodeStack.push(c);
            } else if (c == ')') {
                // 遇见 ) 触发计算，计算之前先弹出 (
                opcodeStack.pop();
                while (!opcodeStack.isEmpty() && (opcodeStack.peek() == '+' || opcodeStack.peek() == '-')) {
                    Integer a = operandsStack.isEmpty() ? 0 : operandsStack.pop();
                    Integer b = operandsStack.isEmpty() ? 0 : operandsStack.pop();
                    operandsStack.push(calculator(opcodeStack.pop(), b, a));
                }
            } else {
                // 求操作数
                num = 0;
                int j = i;
                for (; j < len; j++) {
                    if (s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                        num = num * 10 + (s.charAt(j) - '0');
                    } else {
                        break;
                    }
                }
                // 如果操作码栈，栈顶有操作码，那么也需要进行一波计算
                if (opcodeStack.isEmpty() || (opcodeStack.peek() != '+' && opcodeStack.peek() != '-')) {
                    operandsStack.push(num);
                } else {
                    operandsStack.push(calculator(opcodeStack.pop(), operandsStack.isEmpty() ? 0 : operandsStack.pop(), num));
                }
                i = j - 1;
            }
        }
        return operandsStack.pop();
    }

    public static int calculator(char opcode, Integer operandsA, Integer operandsB) {
        return '+' == opcode ? operandsA + operandsB : operandsA - operandsB;
    }

}
