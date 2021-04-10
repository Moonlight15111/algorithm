package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个整数数组，定义达标子数组如下：含有1和2的数量一样多
 * 求最长的达标子数组的长度。输入数据保证最少有一个1和一个2
 *
 * 输入: [1, 4, 5, 2, 1, 7, 2, 8, 1, 4, 2]  输出: 11
 *
 * 输入: [1, 2, 3, 4, 1, 5] 输出: 5
 *
 * @ClassName LongestSumSubArrayLengthIII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/9 23:41
 * @Version V1.0
 **/
public class LongestSumSubArrayLengthIII {

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 1, 7, 2, 8, 1, 4, 2},
                b = {1, 2, 3, 4, 1, 5};

        System.out.println(longestSumSubArrayLength(a));
        System.out.println(longestSumSubArrayLength(b));
    }

    public static int longestSumSubArrayLength(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                arr[i] = -1;
            } else if (arr[i] != 1) {
                arr[i] = 0;
            }
        }
        // 求累加和为0的最长子数组
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum ));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
