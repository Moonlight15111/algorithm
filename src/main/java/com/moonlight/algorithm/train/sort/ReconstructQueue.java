package com.moonlight.algorithm.train.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 *
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 *
 * 输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]   输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释：
 *     编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
 *     编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
 *     编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 *     编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 *     编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 *     编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
 *     因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
 *
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]   输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 *
 * @ClassName ReconstructQueue
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/4/17 14:04
 * @Version V1.0
 **/
public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] a = {
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        }, b = {
                {6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}
        };
        int[][] res = reconstructQueue(a);
        for (int[] x : res) {
            System.out.println(Arrays.toString(x));
        }

        res = reconstructQueue(b);
        for (int[] x : res) {
            System.out.println(Arrays.toString(x));
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        // 按照身高H降序，人数K升序进行排序
        // 直接插到K位置上即可
        // 高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        for (int[] a : people) {
            list.add(a[1], a);
        }
        return list.toArray(people);
    }

}
