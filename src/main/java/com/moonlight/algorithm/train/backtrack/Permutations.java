package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/permutations/
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * @ClassName Permutations
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/7 13:26
 * @Version V1.0
 **/
public class Permutations {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(permute(a).toString());
    }

//    void backtracking(参数) {
//        if (终止条件) {
//            存放结果;
//            return;
//        }
//
//        for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
//            处理节点;
//            backtracking(路径，选择列表); // 递归
//            回溯，撤销处理结果
//        }
//    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        backtrack(0, nums, used, new ArrayList<>(), res);
        return res;
    }

    public static void backtrack(int index, int[] source, boolean[] used, List<Integer> path, List<List<Integer>> res) {
        if (index == source.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0, len = source.length; i < len; i++) {
            if (!used[i]) {
                path.add(source[i]);
                used[i] = true;
                backtrack(index + 1, source, used, path, res);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

}
