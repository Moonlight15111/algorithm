package com.moonlight.algorithm.train.bitManipulation;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/submissions/
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 * 请你返回排序后的数组
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 * @author Moonlight
 * @date 2020/12/18 16:17
 */
public class SortByBits {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(sortByBits(arr)));

        int[] arr2 = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        System.out.println(Arrays.toString(sortByBits(arr2)));

        int[] arr3 = {10000, 10000};
        System.out.println(Arrays.toString(sortByBits(arr3)));

        int[] arr4 = {2, 3, 5, 7, 11, 13, 17, 19};
        System.out.println(Arrays.toString(sortByBits(arr4)));

        int[] arr5 = {10, 100, 1000, 10000};
        System.out.println(Arrays.toString(sortByBits(arr5)));
    }

    public static int[] sortByBits(int[] arr) {
        int x;
        int y;
        for (int i = 1, length = arr.length; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                x = arr[j];
                y = arr[j + 1];
                if (Integer.bitCount(x) > Integer.bitCount(y) || (Integer.bitCount(x) == Integer.bitCount(y) && x > y)) {
                    arr[j + 1] = x;
                    arr[j] = y;
                }
            }
        }
        return arr;
    }

}
