package com.moonlight.algorithm.train.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/next-greater-element-ii/
 *
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 输入: [1,2,1]    输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 *       数字 2 找不到下一个更大的数；
 *       第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 *
 * @author Moonlight
 * @date 2021/3/6 9:13
 */
public class NextGreaterElementsII {

    public static void main(String[] args) {
        int[] a = {1, 2, 1}, b = {5, 4, 3, 2, 1}, c = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100}, d = {1, 8, -1, -100, -1, 222, 1111111, -111111};
        System.out.println(Arrays.toString(nextGreaterElements(a)) + ", " + Arrays.toString(nextGreaterElementsStack(a)));
        System.out.println(Arrays.toString(nextGreaterElements(b)) + ", " + Arrays.toString(nextGreaterElementsStack(b)));
        System.out.println(Arrays.toString(nextGreaterElements(c)) + ", " + Arrays.toString(nextGreaterElementsStack(c)));
        System.out.println(Arrays.toString(nextGreaterElements(d)) + ", " + Arrays.toString(nextGreaterElementsStack(d)));
    }

    public static int[] nextGreaterElementsStack(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 单调栈，遍历两次
        int len = nums.length;

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }

        return res;
    }

    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        // 对于任意一个位置 i，找左边最远比它大的，右边最近的比它大的
        int[] res = new int[len];
        Arrays.fill(res, -1);

        boolean find;
        for (int i = 0; i < len; i++) {
            find = false;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    find = true;
                    break;
                }
            }
            if (!find) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] > nums[i]) {
                        res[i] = nums[j];
                    }
                }
            }
        }

        return res;
    }
}
