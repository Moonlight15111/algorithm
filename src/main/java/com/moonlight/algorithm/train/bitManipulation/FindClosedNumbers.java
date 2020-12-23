package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/closed-number-lcci/
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）
 * 输入：num = 2（或者0b10）
 * 输出：[4, 1] 或者（[0b100, 0b1]）
 *
 * 输入：num = 1
 * 输出：[2, -1]
 * @author Moonlight
 * @date 2020/12/23 11:19
 */
public class FindClosedNumbers {

    public static void main(String[] args ) {
        System.out.println(Arrays.toString(findClosedNumbers(2)));
        System.out.println(Arrays.toString(findClosedNumbers(1)));
        System.out.println(Arrays.toString(findClosedNumbers(Integer.MAX_VALUE)));
    }

    public static int[] findClosedNumbers(int num) {
        int[] res = new int[]{-1, -1};
        int bitOneCount = Integer.bitCount(num);
        if (num != Integer.MAX_VALUE) {
            for (int i = num + 1; i < Integer.MAX_VALUE ; i++) {
                if (Integer.bitCount(i) == bitOneCount) {
                    res[0] = i;
                    break;
                }
            }
            for (int i = num - 1; i >= 1; i--) {
                if (Integer.bitCount(i) == bitOneCount) {
                    res[1] = i;
                    break;
                }
            }
        }
        return res;
    }

}
