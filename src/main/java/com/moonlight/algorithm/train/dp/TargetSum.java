package com.moonlight.algorithm.train.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/target-sum/
 *
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 输入：nums: [1, 1, 1, 1, 1], S: 3  输出：5
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * 一共有5种方法让最终目标和为3。
 *
 * @ClassName TargetSum
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/20 22:09
 * @Version V1.0
 **/
public class TargetSum {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(a, 3) + ", " + findTargetSumWays123(a, 3));
    }

    public static int dp(int[] nums, int target) {
        // todo dp
        return 0;
    }

    public static int findTargetSumWays123(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();
        return process123(nums, 0, target, cache);
    }

    public static int process123(int[] nums, int index, int rest,  Map<Integer, Map<Integer, Integer>> cache) {
        if (index == nums.length) {
            return rest == 0 ? 1 : 0;
        }
        if (cache.containsKey(index) && cache.get(index).containsKey(rest)) {
            return cache.get(index).get(rest);
        }
        int res = process123(nums, index + 1, rest - nums[index], cache) + process123(nums, index + 1, rest + nums[index], cache);
        if (!cache.containsKey(index)) {
            cache.put(index, new HashMap<>());
        }
        cache.get(index).put(rest, res);
        return res;
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return process(nums, 0, target);
    }

    public static int process(int[] nums, int index, int rest) {
        if (index == nums.length) {
            return rest == 0 ? 1 : 0;
        }
        return process(nums, index + 1, rest - nums[index]) + process(nums, index + 1, rest + nums[index]);
    }

}
