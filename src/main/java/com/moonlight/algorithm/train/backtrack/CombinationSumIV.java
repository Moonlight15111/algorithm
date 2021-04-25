package com.moonlight.algorithm.train.backtrack;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target
 * 请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 *
 * 输入：nums = [1,2,3], target = 4   输出：7
 *
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 *
 * 输入：nums = [9], target = 3
 * 输出：0
 *
 * @ClassName CombinationSumIV
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/24 12:33
 * @Version V1.0
 **/
public class CombinationSumIV {

    public static void main(String[] args) {
        int[] a = {1, 2, 3}, b = {9}, c = {3, 1, 2, 4};
        System.out.println(combinationSum4Backtrack(a, 4) + ", " + combinationSum4Recursion(a, 4) + ", " + combinationSum4Memory(a, 4) + ", " + combinationSum4dp(a, 4));
        System.out.println(combinationSum4Backtrack(b, 3) + ", " + combinationSum4Recursion(b, 3) + ", " + combinationSum4Memory(b, 3) + ", " + combinationSum4dp(b, 3));
        System.out.println(combinationSum4Backtrack(c, 4) + ", " + combinationSum4Recursion(c, 4) + ", " + combinationSum4Memory(c, 4) + ", " + combinationSum4dp(c, 4));
    }

    public static int combinationSum4dp(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
               if (i >= n) {
                   dp[i] += dp[i - n];
               }
            }
        }
        return dp[target];
    }

    public static int combinationSum4Memory(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return process(nums, target, map);
    }

    private static int process(int[] nums, int target, Map<Integer, Integer> map) {
        if (map.containsKey(target)) {
            return map.get(target);
        }
        if (target < 0) {
            map.put(target, 0);
            return 0;
        }
        int count = 0;
        for (int n : nums) {
            count += process(nums, target - n, map);
        }
        map.put(target, count);

        return count;
    }

    public static int combinationSum4Recursion(int[] nums, int target) {
        // 10000% timeout
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }

        int count = 0;
        for (int n : nums) {
            count += combinationSum4Recursion(nums, target - n);
        }

        return count;
    }

    static int ans;
    public static int combinationSum4Backtrack(int[] nums, int target) {
        // timeout
        List<List<Integer>> res = new ArrayList<>();
        ans = 0;
        Arrays.sort(nums);

        backtrack(0, target, nums, new ArrayList<>(), res);

//        for (List<Integer> list : res) {
//            System.out.println(list);
//        }

        return ans;
    }

    private static void backtrack(int sum, int target, int[] nums, List<Integer> path, List<List<Integer>> res) {
        if (target == sum) {
            ans++;
            res.add(new ArrayList<>(path));
            return;
        }

        for (int num : nums) {
            sum += num;
            if (sum > target) {
                break;
            }
            path.add(num);
            backtrack(sum, target, nums, path, res);
            path.remove(path.size() - 1);
            sum -= num;
        }

    }

}
