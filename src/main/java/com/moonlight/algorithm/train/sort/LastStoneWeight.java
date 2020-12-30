package com.moonlight.algorithm.train.sort;

import java.util.PriorityQueue;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/last-stone-weight/
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 * @author Moonlight
 * @date 2020/12/30 14:14
 */
public class LastStoneWeight {

    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(arr));;
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones == null) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i : stones) {
            queue.add(i);
        }
        int x, y;
        while (queue.size() > 1) {
            x = queue.poll();
            y = queue.poll();
            if (x - y > 0) {
                queue.add(x - y);
            } else if (x - y < 0) {
                queue.add(y - x);
            }
        }
        return queue.size() == 0 ? 0 : queue.poll();
    }

}
