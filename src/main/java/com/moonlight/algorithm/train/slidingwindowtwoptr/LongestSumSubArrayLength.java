package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求子数组和为K的最长子数组的长度
 *
 * 输入: [3, 2, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1] k = 6
 * 输出：6
 * 解释：1 + 1 + 1 + 1 + 1 + 1 = 6
 *
 * @ClassName LongestSumSubArray
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/5 22:59
 * @Version V1.0
 **/
public class LongestSumSubArrayLength {

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1};
        System.out.println(subArrayLongestLength(a, 6));
    }

    public static int subArrayLongestLength(int[] arr, int k) {
        int left = 0, right = 0, sum = arr[0], res = 0;
        while (right < arr.length) {
            if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else if (sum > k) {
                sum -= arr[left++];
            } else {
                res = Math.max(res, right - left + 1);
                sum -= arr[left++];
            }
        }
        return res;
    }

}
