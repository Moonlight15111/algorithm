package com.moonlight.algorithm.train.greedy;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/couples-holding-hands/
 *
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。
 * 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。
 * 一次交换可选择任意两人，让他们站起来交换座位。
 * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
 * 这些情侣的初始座位 row[i] 是由最初始坐在第 i 个座位上的人决定的。
 *
 * 输入: row = [0, 2, 1, 3]   输出: 1  解释: 我们只需要交换row[1]和row[2]的位置即可。
 *
 * 输入: row = [3, 2, 0, 1]   输出: 0  解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 *
 * @author Moonlight
 * @date 2021/3/3 10:33
 */
public class CouplesHoldingHands {

    public static void main(String[] args) {
        int[] a = {0, 2, 1, 3};
        int[] b = {3, 2, 0, 1};
        int[] c = {0, 2, 4, 6, 7, 1, 3, 5};
        System.out.println(minSwapsCouples(a));
        System.out.println(minSwapsCouples(b));
        System.out.println(minSwapsCouples(c));
    }

    public static int minSwapsCouples(int[] row) {
        // 题目的意思是要求：2 * i 和 2 * i + 1 互为左右
        // 按顺序编号，则： 1. i 的情侣 必为 i ^ 1
        // 先将情侣的位置建立一个索引，进行预处理
        // 找到第 i 个人对应的情侣 j ，如果就在旁边就不用换了
        // 不在旁边就需要找到 j 所在位置进行交换，并更新索引
        int length = row.length, res = 0;
        int[] index = new int[length];

        for (int i = 0; i < length; i++) {
            index[row[i]] = i;
        }

        int couples;
        for (int i = 0; i < length; i += 2) {
            // 找到 i 的情侣
            couples = row[i] ^ 1;
            // 就在旁边就不用换了
            if (row[i + 1] == couples) {
                continue;
            }
            // 和旁边的换一下,更新索引
            swap(row, index, index[couples], i + 1);
            res++;
        }

        return res;
    }

    public static void swap(int[] row, int[] index, int i, int j) {
        int tmp = row[i];
        row[i] = row[j];
        row[j] = tmp;

        index[row[i]] = i;
        index[row[j]] = j;
    }

}
