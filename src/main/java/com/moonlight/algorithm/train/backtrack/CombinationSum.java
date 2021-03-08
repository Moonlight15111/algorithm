package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/combination-sum/
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 所有数字（包括 target）都是正整数。解集不能包含重复的组合。
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：[[7], [2,2,3]]
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：[ [2,2,2,2], [2,3,3], [3,5]]
 *
 * @author Moonlight
 * @date 2021/3/8 15:22
 */
public class CombinationSum {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(0, 0, target, candidates, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int index, int sum, int target, int[] candidates, ArrayList<Integer> path, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {

        }
    }

}
