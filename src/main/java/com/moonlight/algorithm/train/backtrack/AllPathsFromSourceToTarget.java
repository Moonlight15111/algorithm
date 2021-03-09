package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * 给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点
 * （译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ）空就是没有下一个结点了。
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 *
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 *
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 *
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 *
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 *
 * @author Moonlight
 * @date 2021/3/9 17:35
 */
public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {1, 2}, {3}, {3}, {}
        }, b = new int[][] {
                {4, 3, 1}, {3, 2, 4}, {3}, {4}, {}
        }, c = new int[][] {
                {1}, {}
        }, d = new int[][] {
                {1, 2, 3}, {2}, {3}, {}
        }, e = new int[][] {
                {1, 3}, {2}, {3}, {}
        };
        System.out.println(allPathsSourceTarget(a));
        System.out.println(allPathsSourceTarget(b));
        System.out.println(allPathsSourceTarget(c));
        System.out.println(allPathsSourceTarget(d));
        System.out.println(allPathsSourceTarget(e));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0 || graph[0].length == 0) {
            return res;
        }
        backtrack(0, graph, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int index, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        path.add(index);
        if (index == graph.length - 1) {
            res.add(new ArrayList<>(path));
        }
        for (int n : graph[index]) {
            backtrack(n, graph, path, res);
        }
        path.remove(path.size() - 1);
    }

}
