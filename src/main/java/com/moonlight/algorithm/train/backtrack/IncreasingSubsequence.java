package com.moonlight.algorithm.train.backtrack;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
 *
 * 输入：[4, 6, 7, 7]
 * 输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 * @author Moonlight
 * @date 2021/4/21 18: 06
 */
public class IncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {4, 6, 7, 7};
        List<List<Integer>> subsequences = findSubsequences(a);
        for (List<Integer> list : subsequences) {
            System.out.println(list);
        }
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        process(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private static void process(int[] nums, int index, ArrayList<Integer> path, List<List<Integer>> ans) {
        if (path.size() > 1) {
            ans.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if ((!path.isEmpty() && nums[i] < path.get(path.size() - 1)) || !set.add(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            process(nums, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }

}