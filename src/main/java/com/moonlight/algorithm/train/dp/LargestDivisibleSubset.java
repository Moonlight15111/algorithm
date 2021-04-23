package com.moonlight.algorithm.train.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/largest-divisible-subset/
 *
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 *    answer[i] % answer[j] == 0 ，或
 *    answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 * 输入：nums = [1,2,3]   输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 *
 * 输入：nums = [1,2,4,8]  输出：[1,2,4,8]
 *
 * @author Moonlight
 * @date 2021/4/23 12:43
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] a = {1, 2, 3}, b = {1, 2, 4, 8}, c = {1};

        System.out.println(largestDivisibleSubset(a));
        System.out.println(largestDivisibleSubset(b));
        System.out.println(largestDivisibleSubset(c));
    }

    public static List<Integer> dp(int[] nums) {
        // todo dp
        return new ArrayList<>();
    }

    static List<Integer> ans;
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        // timeout
        ans = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>());

        return ans;
    }

    private static void backtrack(int[] nums, int index, List<Integer> path) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (validate(path, nums[i])) {
                path.add(nums[i]);
                if (path.size() > ans.size()) {
                    ans = new ArrayList<>(path);
                }
                backtrack(nums, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean validate(List<Integer> path, int num) {
        if (path.isEmpty()) {
            return true;
        }

        for (int n : path) {
            if (num % n != 0) {
                return false;
            }
        }

        return true;
    }

}
