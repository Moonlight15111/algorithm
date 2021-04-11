package com.moonlight.algorithm.train.other;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 输入：n = 10   输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 *
 * 输入：n = 1  输出：1
 * 解释：1 通常被视为丑数。
 *
 * @ClassName UglyNumberII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/11 15:49
 * @Version V1.0
 **/
public class UglyNumberII {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);

        long poll = 1L;
        for (int i = 0; i < n; i++) {
            poll = queue.poll();
            if (!queue.contains(2 * poll)) {
                queue.add(2 * poll);
            }
            if (!queue.contains(3 * poll)) {
                queue.add(3 * poll);
            }
            if (!queue.contains(5 * poll)) {
                queue.add(5 * poll);
            }
        }
        return (int)poll;
    }

}
