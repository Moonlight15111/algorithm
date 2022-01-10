package com.moonlight.algorithm.train.other;

/**
 * https://leetcode-cn.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 *
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。
 * 例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 *
 * 输入：n = "32" 输出：3
 * 解释：10 + 11 + 11 = 32
 *
 * 输入：n = "82734" 输出：8
 *
 * 输入：n = "27346209830709182346" 输出：9
 *
 * @author Moonlight
 */
public class MinPartitions {

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    public static int minPartitions(String n) {
        char max = n.charAt(0);
        for (char c : n.toCharArray()) {
            if (c > max) {
                max = c;
            }
        }
        return Integer.parseInt(String.valueOf(max));
    }

}
