package com.moonlight.algorithm.train.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 * 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 * 如果可以，请返回 True；否则，返回 False。
 *
 * 输入：nums = [1,2,3,3,4,4,5,6], k = 4  输出：true
 * 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 *
 * 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3  输出：true
 * 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 *
 * 输入：nums = [3,3,2,2,1,1], k = 3  输出：true
 *
 * 输入：nums = [1,2,3,4], k = 3  输出：false
 * 解释：数组不能分成几个大小为 3 的子数组。
 *
 * @author Moonlight
 */
public class IsPossibleDivide {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 4, 4, 5, 6}, b = {3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11},
              c = {3, 3, 2, 2, 1, 1}, d = {1, 2, 3, 4};

        System.out.println(isPossibleDivide(a, 4));
        System.out.println(isPossibleDivide(b, 3));
        System.out.println(isPossibleDivide(c, 3));
        System.out.println(isPossibleDivide(d, 3));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length % k != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        Arrays.sort(nums);

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int cnt = 0;
        for (int n : nums) {
            if (map.getOrDefault(n, 0) <= 0) {
                continue;
            }
            map.put(n, map.get(n) - 1);
            for (int i = 1; i < k; i++) {
                if (map.getOrDefault(n + i, 0) <= 0) {
                    return false;
                }
                map.put(n + i, map.get(n + i) - 1);
            }
            cnt++;
        }

        return cnt == nums.length / k;
    }

}