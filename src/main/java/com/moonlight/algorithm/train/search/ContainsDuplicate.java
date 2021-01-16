package com.moonlight.algorithm.train.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/contains-duplicate/
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 输入: [1,2,3,1]   输出: true
 *
 * 输入: [1,2,3,4]   输出: false
 *
 * @author Moonlight
 * @date 2021/1/16 14:35
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate1231(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                return true;
            } else {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
        }
        return false;
    }

}
