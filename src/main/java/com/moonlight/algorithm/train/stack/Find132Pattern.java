package com.moonlight.algorithm.train.stack;

import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/132-pattern/
 *
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 输入: [1, 2, 3, 4]    输出: False
 * 解释: 序列中不存在132模式的子序列。
 *
 * 输入: [3, 1, 4, 2]   输出: True
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 *
 * 输入: [-1, 3, 2, 0]  输出: True
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 *
 * @author Moonlight
 * @date 2021/3/24 8:54
 */
public class Find132Pattern {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4}, b = {3, 1, 4, 2}, c = {-1, 3, 2, 0}, d = {3, 5, 0 , 3, 4};
        // false
        System.out.println(find132pattern(a));
        // true
        System.out.println(find132pattern(b));
        // true
        System.out.println(find132pattern(c));
        // true  3、5、4
        System.out.println(find132pattern(d));
    }

    public static boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        // 维护一个单调栈stack，存放3，维护一个变量second存放2，从后往前找，如果有某个位置的数 < second 则说明找到了1
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                second = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

}
