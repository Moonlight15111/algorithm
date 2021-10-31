package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-covered-intervals/
 *
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]  输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 * @ClassName RemoveCoveredIntervals
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/31 13:01
 * @Version V1.0
 **/
public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        int[][] a = {
                {1, 4}, {3, 6}, {2, 8}
        };
        System.out.println(removeCoveredIntervals(a));
    }

    public static int removeCoveredIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int cnt = 0, e = 0, pe = 0;
        for (int[] i : intervals) {
            e = i[1];
            if (e > pe) {
                cnt++;
                pe = e;
            }
        }
        return cnt;
    }

}
