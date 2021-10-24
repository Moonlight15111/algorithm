package com.moonlight.algorithm.train.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/non-overlapping-intervals/
 *
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 注意:
 *   1. 可以认为区间的终点总是大于它的起点。
 *   2. 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]   输出: 1
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 *
 * 输入: [ [1,2], [1,2], [1,2] ]   输出: 2
 * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
 *
 * 输入: [ [1,2], [2,3] ]  输出: 0
 * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 *
 * @ClassName EraseOverlapIntervals
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/24 13:49
 * @Version V1.0
 **/
public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2}, {2, 3}, {3, 4}, {1, 3}
        }, b = {
                {1, 2}, {1, 2}, {1, 2}
        }, c = {
                {1, 2}, {2, 3}
        };
        System.out.println(eraseOverlapIntervals(a));
        System.out.println(eraseOverlapIntervals(b));
        System.out.println(eraseOverlapIntervals(c));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int[] p = null;
        int ans = 0;
        for (int[] arr : intervals) {
            int l = arr[0], r = arr[1];
            if (p == null) {
                p = new int[]{l, r};
            } else if (l < p[1]) {
                ans++;
                // 因为题目要求的是移除区间的最小数量，所以因该取较小的
                p[1] = Math.min(r, p[1]);
            } else {
                p[1] = r;
            }
        }
        return ans;
    }

}