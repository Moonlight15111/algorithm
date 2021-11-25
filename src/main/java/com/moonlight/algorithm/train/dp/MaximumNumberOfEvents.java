package com.moonlight.algorithm.train.dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended-ii/
 *
 * 给你一个 events 数组，其中 events[i] = [startDayi, endDayi, valuei] ，
 * 表示第 i 个会议在 startDayi 天开始，第 endDayi 天结束，如果你参加这个会议，你能得到价值 valuei 。
 * 同时给你一个整数 k 表示你能参加的最多会议数目。
 * 你同一时间只能参加一个会议。如果你选择参加某个会议，那么你必须 完整 地参加完这个会议。
 * 会议结束日期是包含在会议内的，也就是说你不能同时参加一个开始日期与另一个结束日期相同的两个会议。
 * 请你返回能得到的会议价值 最大和 。
 *
 * 输入：events = [[1,2,4],[3,4,3],[2,3,1]], k = 2  输出：7
 * 解释：选择绿色的活动会议 0 和 1，得到总价值和为 4 + 3 = 7 。
 *
 * 输入：events = [[1,2,4],[3,4,3],[2,3,10]], k = 2  输出：10
 * 解释：参加会议 2 ，得到价值和为 10 。
 * 你没法再参加别的会议了，因为跟会议 2 有重叠。你 不 需要参加满 k 个会议。
 *
 * 输入：events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3  输出：9
 * 解释：尽管会议互不重叠，你只能参加 3 个会议，所以选择价值最大的 3 个会议。
 *
 * @author Moonlight
 */
public class MaximumNumberOfEvents {

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 4}, {3, 4, 3}, {2, 3, 1}
        }, b = {
                {1, 2, 4}, {3, 4, 3}, {2, 3, 10}
        }, c = {
                {1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}
        };

        System.out.println(recursion(a, 2) + ", " + maxValue(a, 2) + ", ");
        System.out.println(recursion(b, 2) + ", " + maxValue(b, 2) + ", ");
        System.out.println(recursion(c, 3) + ", " + maxValue(c, 3) + ", ");
    }

    public static int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        int[][] memory = new int[events.length + 1][k + 1];
        for (int[] arr : memory) {
            Arrays.fill(arr, -1);
        }
        return memory(events, 0, memory, k);
    }

    private static int memory(int[][] events, int cur, int[][] memory, int k) {
        if (cur >= events.length || k <= 0) {
            memory[cur][k] = 0;
            return 0;
        }
        if (memory[cur][k] != -1) {
            return memory[cur][k];
        }
        int i = cur + 1, ans;
        for (; i < events.length; i++) {
            if (events[i][0] > events[cur][1]) {
                break;
            }
        }
        ans = Math.max(memory(events, i,  memory, k - 1) + events[cur][2],
                memory(events, cur + 1,  memory, k));
        memory[cur][k] = ans;
        return ans;
    }

    public static int recursion(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        return recursion(events, 0, k);
    }

    private static int recursion(int[][] events, int cur, int k) {
        if (cur >= events.length || k <= 0) {
            return 0;
        }
        // 对于每个会议都可以选择参加或者不参加，需要在 参加当前这个会 和 不参加当前这个会 之间取最大值
        // 决定参加当前这个会，那么下一个会议则必须在这个会议结束之后
        int i = cur + 1;
        for (; i < events.length; i++) {
            if (events[i][0] > events[cur][1]) {
                break;
            }
        }
        // Max(参加当前这个会，不参加当前这个会议)
        return Math.max(recursion(events, i, k - 1) + events[cur][2],
                        recursion(events, cur + 1, k));
    }

}
