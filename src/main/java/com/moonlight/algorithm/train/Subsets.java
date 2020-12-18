package com.moonlight.algorithm.train;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/subsets/
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 输入: nums = [1,2,3]
 * 输出: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
 * @author Moonlight
 * @date 2020/12/18 9:49
 */
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr).toString());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int j = i, length = nums.length; j < length; j++) {
            list.add(nums[j]);
            backtrack(j + 1, nums, res, list);
            list.remove(list.size() - 1);
        }
    }

}
