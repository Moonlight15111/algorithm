package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/maximum-swap/
 *
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 输入: 2736   输出: 7236
 * 解释: 交换数字2和数字7。
 *
 * 输入: 9973   输出: 9973
 * 解释: 不需要交换。
 *
 * @author Moonlight
 * @date 2021/5/21 13:12
 */
public class MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap(2736) + ", " + oN(2736));
        System.out.println(maximumSwap(9973) + ", " + oN(9973));
    }

    public static int oN(int num) {
        if (num <= 10) {
            return num;
        }
        // 记录每个数字出现的最后一次出现的下标
        // 从左向右扫描，找到当前位置右边的最大的数字并交换
        char[] chars = (num + "").toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - '0'] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            for (int j = 9; j > chars[i] - '0'; j--) {
                if (last[j] > i) {
                    swap(chars, i, last[j]);
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }

    public static int maximumSwap(int num) {
        char[] chars = (num + "").toCharArray();
        int max = num;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                swap(chars, i, j);
                max = Math.max(max, Integer.parseInt(new String(chars)));
                swap(chars, i, j);
            }
        }
        return max;
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

}