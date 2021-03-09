package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/combinations/
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 *
 * @author Moonlight
 * @date 2021/3/9 16:38
 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) {
            return res;
        }
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int index, int n, int k, ArrayList<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 剪枝：搜索七点是有上界的，比如n = 7, k = 4 当 n = 5 时就没必要继续搜索了，因为从 5 开始后面也就 6 和 7，
        // 凑不出 4 个数了，根据归纳可以得出: 搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
        // 又因为：接下来要选择的元素个数 = k - path.size()
        // 可得：搜索起点的上界 = n - (k - path.size()) + 1
        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtrack(i + 1, n, k, path, res);
            path.remove(path.size() - 1);
        }
//        for (int i = index; i <= n; i++) {
//            path.add(i);
//            backtrack(i + 1, n, k, path, res);
//            path.remove(path.size() - 1);
//        }
    }

}
