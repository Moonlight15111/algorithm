package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-k-digits/
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *    num 的长度小于 10002 且 ≥ k。
 *    num 不会包含任何前导零。
 *
 * 输入: num = "1432219", k = 3   输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 输入: num = "10200", k = 1    输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 输入: num = "10", k = 2  输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * @ClassName RemoveKDigits
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/17 13:10
 * @Version V1.0
 **/
public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("10200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits("10", 1));
        System.out.println(removeKDigits("112", 1));
    }

    public static String removeKDigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        // 单调栈
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // 防止出现最大的数字出现在最后的情况。比如: 112、11111129
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.reverse();
        while (builder.length() > 1 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

}
