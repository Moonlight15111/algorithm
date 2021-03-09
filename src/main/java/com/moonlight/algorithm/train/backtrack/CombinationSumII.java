package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题: https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 *  [
 *   [1,2,2],
 *   [5]
 *  ]
 *
 * @author Moonlight
 * @date 2021/3/9 13:13
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5}, b = {2, 5, 2, 1, 2};
        System.out.println(combinationSum2(a, 8));
        System.out.println(combinationSum2(b, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        backtrack(0, 0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int index, int sum, int target,
                                  int[] candidates, ArrayList<Integer> path, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index, len = candidates.length; i < len; i++) {
            if (sum + candidates[i] <= target) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                backtrack(i + 1, sum + candidates[i], target, candidates, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}
