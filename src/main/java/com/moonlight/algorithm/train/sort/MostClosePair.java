package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个含有N个值的数组a[]，在其中找到一对最接近的值，两者之差(绝对值)最小的两个数
 * @author Moonlight
 * @date 2021/1/5 13:25
 */
public class MostClosePair {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 13, 9, 4, 5};
        System.out.println(Arrays.toString(mostClosePair(arr)));
    }

    public static int[] mostClosePair(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        Arrays.sort(arr);
        int minVal = Integer.MAX_VALUE, minIndex = 0;
        for (int i = 1, len = arr.length; i < len; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) < minVal) {
                minIndex = i;
                minVal = Math.abs(arr[i] - arr[i - 1]);
            }
        }
        return new int[]{arr[minIndex], arr[minIndex - 1]};
    }

}
