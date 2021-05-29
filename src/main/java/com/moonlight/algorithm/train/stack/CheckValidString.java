package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/valid-parenthesis-string/
 *
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *    任何左括号 ( 必须有相应的右括号 )。
 *    任何右括号 ) 必须有相应的左括号 ( 。
 *    左括号 ( 必须在对应的右括号之前 )。
 *    * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *    一个空字符串也被视为有效字符串。
 *
 *  输入: "()"    输出: True
 *  输入: "(*)"   输出: True
 *  输入: "(*))"  输出: True
 *
 * @author Moonlight
 * @date 2021/5/24 12:44
 */
public class CheckValidString {

    public static void main(String[] args) {
        System.out.println(checkValidString("()"));
        System.out.println(checkValidString("(*)"));
        System.out.println(checkValidString("(*))"));
        System.out.println(checkValidString("("));
        System.out.println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"));
    }

    public static boolean checkValidString(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Integer> ls = new Stack<>(), ss = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                ls.add(i);
            } else if (chars[i] == '*') {
                ss.add(i);
            } else {
                if (ls.isEmpty() && ss.isEmpty()) {
                    return false;
                }
                if (!ls.isEmpty()) {
                    ls.pop();
                } else if (!ss.isEmpty()) {
                    ss.pop();
                }
            }
        }
        if (ss.size() < ls.size()) {
            return false;
        }
        while (!ls.isEmpty() && !ss.isEmpty()) {
            if (ls.peek() >= ss.peek()) {
                return false;
            }
            ls.pop();
            ss.pop();
        }
        return true;
    }

}