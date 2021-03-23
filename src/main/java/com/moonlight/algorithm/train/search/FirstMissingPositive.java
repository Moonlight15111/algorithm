package com.moonlight.algorithm.train.search;

import java.util.Map;
import java.util.HashMap;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
 *
 * 输入：nums = [1,2,0]    输出：3
 *
 * 输入：nums = [3,4,-1,1]   输出：2
 *
 * 输入：nums = [7,8,9,11,12]   输出：1
 *
 * @author Moonlight
 * @date 2021/3/23 16:17
 */
public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] a = {1, 2, 0}, b = {3, 4, -1, 1}, c = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(a));
        System.out.println(firstMissingPositive(b));
        System.out.println(firstMissingPositive(c));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        // 能过，但是太捞了，而且不合符题目要求
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!map.containsKey(i)) {
                return i;
            }
        }
        return 1;
    }
}
