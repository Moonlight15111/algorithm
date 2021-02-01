package com.moonlight.algorithm.train.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈 - 栈从栈底到栈顶由小到大
 * 给定一个无重复数的数组，求每个位置左右两边离它最近的比它小的数，如果没有就返回-1
 * 输入：[0, 3, 2, 1] 输出：[[-1, -1], [0, 2], [0, 1], [0, -1]]
 * @ClassName MonotonousStack
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/1 21:02
 * @Version V1.0
 **/
public class MonotonousStack {

    public static int[][] getNearLessNoRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int pop = stack.pop();
                int left = stack.isEmpty() ? -1 : arr[stack.peek()];
                res[pop][0] = left;
                res[pop][1] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popIndex = stack.pop();
            int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftLessIndex;
            res[popIndex][1] = -1;
        }

        return res;
    }

    public static int[][] getNearLessRepeat(int[] arr) {
        int[][] res = new int[arr.length][2];

        Stack<List<Integer>> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek().get(0)] > arr[i]) {
                List<Integer> popIs = stack.pop();
                // 取位于下面位置的列表中，最晚加入的那个
                int left = stack.isEmpty() ? -1 : arr[stack.peek().get(stack.peek().size() - 1)];
                for (Integer n : popIs) {
                    res[n][0] = left;
                    res[n][1] = arr[i];
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().get(0)] == arr[i]) {
                stack.peek().add(Integer.valueOf(i));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            List<Integer> popIs = stack.pop();
            // 取位于下面位置的列表中，最晚加入的那个
            int leftLessIndex = stack.isEmpty() ? -1 : arr[stack.peek().get(stack.peek().size() - 1)];
            for (Integer n : popIs) {
                res[n][0] = leftLessIndex;
                res[n][1] = -1;
            }
        }
        return res;
    }

}