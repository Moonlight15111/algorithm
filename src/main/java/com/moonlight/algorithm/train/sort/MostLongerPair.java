package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个含有N个值的数组a[]，在其中找到一对最遥远的值，即两者之差(绝对值)最大的两个数
 * @author Moonlight
 * @date 2021/1/5 13:18
 */
public class MostLongerPair {

    public static void main(String[] args) {
        int[] arr = {1, 7, 0, -10, 9, 8, 5};
        System.out.println(Arrays.toString(mostLongerPair(arr)));
    }

    public static int[] mostLongerPair(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int min = Math.abs(arr[0]), max = Math.abs(arr[0]);
        for (int val : arr) {
            if (Math.abs(val) < Math.abs(min)) {
                min = val;
            }
            if (Math.abs(val) > Math.abs(max)) {
                max = val;
            }
        }
        return new int[]{min, max};
    }

}
