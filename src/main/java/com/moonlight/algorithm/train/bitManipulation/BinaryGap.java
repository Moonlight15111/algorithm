package com.moonlight.algorithm.train.bitManipulation;

/**
 * https://leetcode-cn.com/problems/binary-gap/
 *
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。
 * 两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 *
 * 输入：n = 22  输出：2
 * 解释：
 * 22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 *
 * 输入：n = 5  输出：2
 *
 * 输入：n = 6  输出：1
 *
 * 输入：n = 8  输出：0
 *
 * @author Moonlight
 */
public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
        System.out.println(binaryGap(8));
    }

    public static int binaryGap(int n) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0, j = -1, t; i < 32; i++) {
            t = 1 << i;
            if ((n & t) == t) {
                if (j != -1) {
                    ans = Math.max(i - j, ans);
                }
                j = i;
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

}