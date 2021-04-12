package com.moonlight.algorithm.train.sort;

import java.util.PriorityQueue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/largest-number/
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 输入：nums = [10,2]  输出："210"
 *
 * 输入：nums = [3,30,34,5,9]  输出："9534330"
 *
 * 输入: [0,0]  输出: "0"
 *
 * @author Moonlight
 * @date 2021/4/12 13:09
 */
public class LargestNumber {

    public static void main(String[] args) {
        int[] a = {10, 2}, b = {3, 30, 34, 5, 9}, c = {0, 0};
        System.out.println(largestNumber(a));
        System.out.println(largestNumber(b));
        System.out.println(largestNumber(c));
    }

    public static String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));

        for (int n : nums) {
            queue.add("" + n);
        }

        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }

        while (builder.charAt(0) == '0' && builder.length() > 1) {
            builder.deleteCharAt(0);
        }

        return builder.toString();
    }

}
