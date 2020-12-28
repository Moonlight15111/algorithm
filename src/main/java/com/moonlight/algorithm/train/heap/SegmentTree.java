package com.moonlight.algorithm.train.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定很多线段，每个线段都有[start，end]来表示线段的开始和结束位置，左右都是闭区间
 * 规定：线段的开始/结束都是整数，线段的重合区域长度必须 >= 1
 * 求线段最多重合区域中，包含了几条线段
 * @ClassName SegmentTree
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/12/28 21:43
 * @Version V1.0
 **/
public class SegmentTree {

    public static void main(String[] args) {
        int[][] arr = new int[4][2];
        arr[0] = new int[]{1, 7};
        arr[1] = new int[]{2, 3};
        arr[2] = new int[]{4, 6};
        arr[3] = new int[]{4, 5};

        System.out.println(sum(arr));
    }

    public static int sum(int[][] arr) {
        // 1. 将线段按起始位置升序排序   2. 踢出小根堆中，小于线段起始位置的数，并将结束位置放入小根堆  3. 循环结束后小根堆中有多少个数，就说明有多个重合线段
        // 以第 i 个线段为例，实质就是说：如果重合区域必须以 i_s 为左边界，有多少条线段会越过 i_e 往右穿，如果线段 j 的 end 位置小于或等于 i_e 则 j 必不可能与 i 重合，所以需要剔除
        List<int[]> list = new ArrayList<>(Arrays.asList(arr));
        list.sort((a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] a : list) {
            while (queue.size() != 0 && queue.peek() <= a[0]) {
                queue.poll();
            }
            queue.add(a[1]);
        }

        return queue.size();
    }

}
