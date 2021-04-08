package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 输入一个都是正整数的数组，数组中的一个或连续多个整数组成一个子数组。
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
        // 1. sum < k : right++
        // 2. sum > k : sum -= arr[left] and left++
        // 3. sum == k : update res and sum -= arr[left] and left++
        // 假设从下标为0的位置到 下标i 位置的和等于 k
        // 则i位置为从0位置出发唯一一个累加和为k的位置，因为数组都是正整数，是具有严格单调性的
        // 0位置找到了那么接下来就去找1位置、2位置....
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
