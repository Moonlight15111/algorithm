package com.moonlight.algorithm.train.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 *
 * 输入：n = 3  输出：5
 *
 * 输入：n = 1  输出：1
 *
 * @ClassName NumTrees
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/8/9 15:13
 * @Version V1.0
 **/
public class NumTrees {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
        System.out.println(numTrees(1));
    }

    public static int numTrees(int n) {
        return count(n, new HashMap<>());
    }

    public static int count(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 树的总数 = 左子树个数 * 右子树个数
            // 当左子树有 i 个节点时，右子树的节点树就为 n - i - 1, 因为还要减去一个头结点
            ans += count(i, cache) * count(n - i - 1, cache);
        }
        cache.put(n, ans);
        return ans;
    }


}