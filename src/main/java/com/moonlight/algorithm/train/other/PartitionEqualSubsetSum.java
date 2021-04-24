package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 输入：nums = [1,5,11,5]  输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 *
 * 输入：nums = [1,2,3,5]   输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * @ClassName PartitionEqualSubsetSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/24 13:57
 * @Version V1.0
 **/
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] a =  {1, 5, 11, 5}, b = {1, 2, 3, 5}, c = {1, 5, 5, 5, 6}, d = {1, 3, 4, 4}, e = {2, 2, 1, 1};
        // true
        System.out.println(recursion(a) + ", " + memory(a));
        // false
        System.out.println(recursion(b) + ", " + memory(b));
        // true
        System.out.println(recursion(c) + ", " + memory(c));
        // false
        System.out.println(recursion(d) + ", " + memory(d));
        // true
        System.out.println(recursion(e) + ", " + memory(e));
    }

    public static boolean dp(int[] nums) {
        // todo dp
        return false;
    }

    public static boolean memory(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        Map<Integer, Boolean> map = new HashMap<>();

        return (sum & 1) == 0 && process(nums, 0, 0, sum / 2, map);
    }

    private static boolean process(int[] nums, int index, int sum, int target, Map<Integer, Boolean> map) {
        if (map.containsKey(sum)) {
            return map.get(sum);
        }
        if (index == nums.length) {
            map.put(sum, sum == target);
            return sum == target;
        }
        boolean c = process(nums, index + 1, sum + nums[index], target, map);
        map.put(sum + nums[index], c);
        boolean nc = process(nums, index + 1, sum, target, map);
        map.put(sum, c || nc);
        return c || nc;
    }

    public static boolean recursion(int[] nums) {
        // timeout
        if (nums.length < 2) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        return (sum & 1) == 0 && process(nums, 0, 0, sum / 2);
    }

    private static boolean process(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            return sum == target;
        }
        return process(nums, index + 1, sum + nums[index], target) || process(nums, index + 1, sum, target);
    }

}
