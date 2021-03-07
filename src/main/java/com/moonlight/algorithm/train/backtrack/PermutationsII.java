package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/permutations-ii/
 *
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 *
 *  输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @ClassName PermutationsII
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/7 14:14
 * @Version V1.0
 **/
public class PermutationsII {

    public static void main(String[] args) {
        int[] a = {1, 1, 2}, b = {1, 2, 3};
        System.out.println(permuteUnique(a));
        System.out.println(permuteUnique(b));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 套模板 见 Permutations
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(0, nums, used, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int index, int[] nums, boolean[] used, ArrayList<Integer> path, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                backtrack(index + 1, nums, used, path, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

}
