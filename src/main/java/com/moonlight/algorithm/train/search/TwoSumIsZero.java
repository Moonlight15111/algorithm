package com.moonlight.algorithm.train.search;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个数组，找出数组中所有和为0的整数对的数量
 * @author Moonlight
 * @date 2020/12/30 13:29
 */
public class TwoSumIsZero {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, -1, -2, -3, -6};
        System.out.println(twoSum(arr));
    }

    public static int twoSum(int[] arr) {
        if (arr == null || arr.length > 2) {
            return 0;
        }
        Arrays.sort(arr);
        int len = arr.length, res = 0;
        for (int i = 0; i < len; i++) {
            if (binarySearch(-arr[i], arr) > i) {
                res++;
            }
        }
        return res;
    }

    public static int binarySearch(int key, int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (arr[mid] < key) {
                left = mid + 1;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
