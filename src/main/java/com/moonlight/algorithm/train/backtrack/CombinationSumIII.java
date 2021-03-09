package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：所有数字都是正整数。解集不能包含重复的组合。
 *
 * 输入: k = 3, n = 7     输出: [[1,2,4]]
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * @author Moonlight
 * @date 2021/3/9 17:07
 */
public class CombinationSumIII {

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, 0, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int index, int sum, int n, int k, ArrayList<Integer> path, List<List<Integer>> res) {
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < 10; i++) {
            if (sum + i <= n) {
                // 剪枝: 最后一个入选的数 = n - sum && 所有数字都是正整数
                if (path.size() == k - 1) {
                    if (n - sum > 9 || n - sum < 1) {
                        continue;
                    }
                }
                path.add(i);
                backtrack(i + 1, sum  + i, n, k, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

}
