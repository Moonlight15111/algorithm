package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 *
 * 给你用户在 LeetCode 的操作日志，和一个整数 k 。日志用一个二维整数数组 logs 表示，
 * 其中每个 logs[i] = [IDi, timei] 表示 ID 为 IDi 的用户在 timei 分钟时执行了某个操作。
 * 多个用户 可以同时执行操作，单个用户可以在同一分钟内执行 多个操作 。
 * 指定用户的 用户活跃分钟数（user active minutes，UAM） 定义为用户对 LeetCode 执行操作的 唯一分钟数 。
 * 即使一分钟内执行多个操作，也只能按一分钟计数。
 * 请你统计用户活跃分钟数的分布情况，统计结果是一个长度为 k 且 下标从 1 开始计数 的数组 answer ，
 * 对于每个 j（1 <= j <= k），answer[j] 表示 用户活跃分钟数 等于 j 的用户数。
 * 返回上面描述的答案数组 answer 。
 *
 * 输入：logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5 输出：[0,2,0,0,0]
 * 解释：
 * ID=0 的用户执行操作的分钟分别是：5 、2 和 5 。因此，该用户的用户活跃分钟数为 2（分钟 5 只计数一次）
 * ID=1 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
 * 2 个用户的用户活跃分钟数都是 2 ，answer[2] 为 2 ，其余 answer[j] 的值都是 0
 *
 * 输入：logs = [[1,1],[2,2],[2,3]], k = 4  输出：[1,1,0,0]
 * 解释：
 * ID=1 的用户仅在分钟 1 执行单个操作。因此，该用户的用户活跃分钟数为 1
 * ID=2 的用户执行操作的分钟分别是：2 和 3 。因此，该用户的用户活跃分钟数为 2
 * 1 个用户的用户活跃分钟数是 1 ，1 个用户的用户活跃分钟数是 2
 * 因此，answer[1] = 1 ，answer[2] = 1 ，其余的值都是 0
 *
 * @ClassName FindingUsersActiveMinutes
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/4 10:52
 * @Version V1.0
 **/
public class FindingUsersActiveMinutes {

    public static void main(String[] args) {
        int[][] a = {
                {0, 5}, {1, 2}, {0, 2}, {0, 5}, {1,3}
        }, b = {
                {1, 1}, {2,2}, {2,3}
        };
        System.out.println(Arrays.toString(findingUsersActiveMinutes(a, 5)));
        System.out.println(Arrays.toString(findingUsersActiveMinutes(b, 4)));

        System.out.println(Arrays.toString(findingUsersActiveMinutes1231(a, 5)));
        System.out.println(Arrays.toString(findingUsersActiveMinutes1231(b, 4)));
    }

//        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//        for (int[] a : logs) {
//            queue.add(a);
//        }
    public static int[] findingUsersActiveMinutes1231(int[][] logs, int k) {
        // 使用Set统计每个用户的活跃分钟
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] a : logs) {
            Set<Integer> orDefault = map.getOrDefault(a[0], new HashSet<>());
            orDefault.add(a[1]);
            map.put(a[0], orDefault);
        }

        for (Set<Integer> set : map.values()) {
            res[set.size() - 1]++;
        }
        return res;
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // timeout
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] a : logs) {
            Set<Integer> orDefault = map.getOrDefault(a[0], new HashSet<>());
            orDefault.add(a[1]);
            map.put(a[0], orDefault);
        }
        for (int i = 0; i < k; i++) {
            int count = 0;
            for (Set<Integer> set : map.values()) {
                if (set.size() == i + 1) {
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }

}
