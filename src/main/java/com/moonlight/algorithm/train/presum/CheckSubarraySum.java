package com.moonlight.algorithm.train.presum;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/continuous-subarray-sum/
 *
 * 给定一个包含 非负数 的数组和一个目标 整数 k ，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n * k ，其中 n 也是一个整数。
 *
 * 输入：[23,2,4,6,7], k = 6   输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 *
 * 输入：[23,2,6,4,7], k = 6   输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 *
 * @author Moonlight
 * @date 2021/5/6 13:45
 */
public class CheckSubarraySum {

    public static void main(String[] args) {
        int[] a = {23, 2, 4, 6, 7}, b = {23, 2, 6, 4, 7}, c = {23, 2, 4, 6, 6};
        System.out.println(preSumArr(a, 6) + ", " + preSumAndMap(a,6));
        System.out.println(preSumArr(b, 6) + ", " + preSumAndMap(b,6));
        System.out.println(preSumArr(c, 7) + ", " + preSumAndMap(c,7));
    }

    public static boolean preSumAndMap(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int presum = 0, mod;
        for (int i = 0; i < nums.length; i++) {
            presum += nums[i];
            // 区间[i, j]的和 = presum[j] - presum[i - 1]
            // 则区间[i, j]的和是否可以整除K就等价于(presum[j] - presum[i - 1] ) % k 是否等于 0
            // 设: (presum[j] - presum[i - 1] ) % k == 0
            // 则: presum[j] % k - presum[i - 1] % k == 0;
            //     presum[j] % k == presum[i - 1] % k
            // 其实就是说区间[i, j]之间的区间和是否为k的倍数
            mod = k == 0 ? presum : presum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    public static boolean preSumArr(int[] nums, int k) {
        // timeout
        if (nums == null || nums.length < 2) {
            return false;
        }
        int n = nums.length;
        int[] help = new int[n + 1];
        for (int i = 0; i < n; i++) {
            help[i + 1] = help[i] + nums[i];
        }

        for (int i = 0, sub; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sub = help[j + 1] - help[i];
                if (sub == k || (k > 0 && sub % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }

}