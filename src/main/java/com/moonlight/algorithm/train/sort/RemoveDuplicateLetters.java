package com.moonlight.algorithm.train.sort;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 输入：s = "bcabc"   输出："abc"
 *
 * 输入：s = "cbacdcbc"  输出："acdb"
 *
 * @author Moonlight
 * @date 2021/4/27 13:18
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public void template() {
        // 1. 去重  2. 去重字符串中的字符顺序不能打乱源字符串中字符出现的相对顺序
//        // 存放去重的结果
//        Stack<Character> stk = new Stack<>();
//        // 布尔数组初始值为 false，记录栈中是否存在某个字符
//        // 输入字符均为 ASCII 字符，所以大小 256 够用了
//        boolean[] inStack = new boolean[256];
//
//        for (char c : s.toCharArray()) {
//            // 如果字符 c 存在栈中，直接跳过
//            if (inStack[c]) continue;
//            // 若不存在，则插入栈顶并标记为存在
//            stk.push(c);
//            inStack[c] = true;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!stk.empty()) {
//            sb.append(stk.pop());
//        }
//        // 栈中元素插入顺序是反的，需要 reverse 一下
//        return sb.reverse().toString();

        // 3.在所有符合上面两条要求的去重字符串中，字典序最小的作为最终结果
        // 所以如果当前字符 'a' 比之前的字符字典序小，就有可能需要把前面的字符 pop 出栈，让 'a' 排在前面
        // 情况一、如果 stk.peek() 这个字符之后还会出现，那么可以把它 pop 出去，反正后面还有嘛，后面再 push 到栈里，刚好符合字典序的要求。
        // 情况二、如果 stk.peek() 这个字符之后不会出现了，前面也说了栈中不会存在重复的元素，那么就不能把它 pop 出去，否则你就永远失去了这个字符。
        Stack<Character> stk = new Stack<>();

        // 维护一个计数器记录字符串中字符的数量，当字典序较小的字符试图「挤掉」栈顶元素的时候，
        // 在 count 中检查栈顶元素是否是唯一的，只有当后面还存在栈顶元素的时候才能挤掉，否则不能挤掉。
//        int[] count = new int[256];
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i)]++;
//        }
//
//        boolean[] inStack = new boolean[256];
//        for (char c : s.toCharArray()) {
//            // 每遍历过一个字符，都将对应的计数减一
//            count[c]--;
//
//            if (inStack[c]) continue;
//
//            while (!stk.isEmpty() && stk.peek() > c) {
//                // 若之后不存在栈顶元素了，则停止 pop
//                if (count[stk.peek()] == 0) {
//                    break;
//                }
//                // 若之后还有，则可以 pop
//                inStack[stk.pop()] = false;
//            }
//            stk.push(c);
//            inStack[c] = true;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        while (!stk.empty()) {
//            sb.append(stk.pop());
//        }
//        return sb.reverse().toString();

    }

    public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] visible = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // 每遍历一次都把它的次数 - 1 表示我已经处理过一次了
            count[c - 'a']--;
            // 如果之前已经处理过相同的元素，那么这个也没必要处理了
            if (visible[c - 'a']) {
                continue;
            }
            // 如果当前栈顶元素字典序大于当前元素，那么尝试把栈顶元素给弹掉
            while (!stack.isEmpty() && stack.peek() > c) {
                // 如果就剩最后一个栈顶元素了，就不弹了
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                visible[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visible[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }

}
