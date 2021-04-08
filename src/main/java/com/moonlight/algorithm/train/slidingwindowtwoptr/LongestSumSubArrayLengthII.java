package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整数数组
 * 求子数组和为K的最长子数组的长度
 *
 * 输入: arr = [5, 6, 4, 3, 0, -3] k = 10
 * 输出: 5
 *
 * 输入: arr = [3, -3, 7] k = 7
 * 输出: 3
 *
 * @ClassName LongestSumSubArrayLengthII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/8 23:34
 * @Version V1.0
 **/
public class LongestSumSubArrayLengthII {

    public static void main(String[] args) {
        int[] a = {5, 6, 4, 3, 0, -3}, b = {3, -3, 7};
        System.out.println(maxLength(a, 10));
        System.out.println(maxLength(b, 7));
    }

    public static int maxLength(int[] arr, int k) {
        // 假设 k = 10 且从下标0位置到i位置的前缀和为15
        // 那么我们只需要求前缀和中从下标0到i之间哪个位置是最早形成 15 - 10 = 5 的
        // key: 前缀和   val: 下标位置  存放的是该前缀和最早出现的位置
        Map<Integer, Integer> map = new HashMap<>();
        // 如果下标0到i位置正好是累加和，这个答案是找不到的
        // 比如: [3, -3, 7] k = 7
        map.put(0, -1);
        int sum = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                res = Math.max(i - map.get(sum - k), res);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }

}
