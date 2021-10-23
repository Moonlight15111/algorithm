package com.moonlight.algorithm.train.sort;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]  输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 输入：intervals = [[1,4],[4,5]]  输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @ClassName Merge
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/23 13:28
 * @Version V1.0
 **/
public class Merge {

    public static void main(String[] args) {
        int[][] a = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        }, b = {
                {1, 4}, {4, 5}
        };

        int[][] merge = merge(a);

        for (int[] x : merge) {
            System.out.print(Arrays.toString(x));
        }

        System.out.println();

        merge = merge(b);

        for (int[] x : merge) {
            System.out.print(Arrays.toString(x));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (list.size() == 0 || list.get(list.size() - 1)[1] < l) {
                list.add(new int[]{l, r});
            } else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], r);
            }
        }

        return list.toArray(new int[list.size()][]);
    }

}
