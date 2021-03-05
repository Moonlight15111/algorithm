package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 *
 * 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 *
 * 输入：A = [1,0,1,0,1], S = 2    输出：4
 *
 * 解释：有 4 个满足题目要求的子数组:  [1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 *
 * @author Moonlight
 * @date 2021/3/5 11:21
 */
public class NumSubarraysWithSum {

    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 1}, b = {1, 0, 0, 0, 1, 1, 1, 0, 0, 1}, c = {};
        System.out.println(numSubarraysWithSum131(a, 2) + ", " + numSubarraysWithSum(a, 2));
        System.out.println(numSubarraysWithSum131(b, 2) + ", " + numSubarraysWithSum(b, 2));
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0, sum = 0;
        for (int n : A) {
            sum += n;
            res += map.getOrDefault(sum - S, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static int numSubarraysWithSum131(int[] A, int S) {
        int len = A.length, sum = 0, res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                sum += A[j];
                if (sum == S) {
                    res++;
                }
            }
            sum = 0;
        }
        return res;
    }

}
