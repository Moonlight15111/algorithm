package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 一个酒店里有 n 个房间，这些房间用二维整数数组 rooms 表示，其中 rooms[i] = [roomIdi, sizei]
 * 表示有一个房间号为 roomIdi 的房间且它的面积为 sizei 。每一个房间号 roomIdi 保证是 独一无二 的。
 * 同时给你 k 个查询，用二维数组 queries 表示，其中 queries[j] = [preferredj, minSizej] 。第 j 个查询的答案是满足如下条件的房间 id ：
 * 房间的面积 至少 为 minSizej ，且abs(id - preferredj) 的值 最小 ，其中 abs(x) 是 x 的绝对值。
 * 如果差的绝对值有 相等 的，选择 最小 的 id 。如果 没有满足条件的房间 ，答案为 -1 。
 * 请你返回长度为 k 的数组 answer ，其中 answer[j] 为第 j 个查询的结果。
 *
 * 输入：rooms = [[2,2],[1,2],[3,2]], queries = [[3,1],[3,3],[5,2]]
 * 输出：[3,-1,3]
 * 解释：查询的答案如下：
 * 查询 [3,1] ：房间 3 的面积为 2 ，大于等于 1 ，且号码是最接近 3 的，为 abs(3 - 3) = 0 ，所以答案为 3 。
 * 查询 [3,3] ：没有房间的面积至少为 3 ，所以答案为 -1 。
 * 查询 [5,2] ：房间 3 的面积为 2 ，大于等于 2 ，且号码是最接近 5 的，为 abs(3 - 5) = 2 ，所以答案为 3 。
 *
 * 输入：rooms = [[1,4],[2,3],[3,5],[4,1],[5,2]], queries = [[2,3],[2,4],[2,5]]
 * 输出：[2,1,3]
 * 解释：查询的答案如下：
 * 查询 [2,3] ：房间 2 的面积为 3 ，大于等于 3 ，且号码是最接近的，为 abs(2 - 2) = 0 ，所以答案为 2 。
 * 查询 [2,4] ：房间 1 和 3 的面积都至少为 4 ，答案为 1 因为它房间编号更小。
 * 查询 [2,5] ：房间 3 是唯一面积大于等于 5 的，所以答案为 3 。
 *
 *
 * @ClassName ClosestRoom
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/1 23:31
 * @Version V1.0
 **/
public class ClosestRoom {

    public static void main(String[] args) {
        int[][] a = {
                {2, 2}, {1, 2}, {3, 2}
        }, b = {
                {1, 4}, {2, 3}, {3, 5}, {4, 1}, {5, 2}
        }, c = {
                {3, 1}, {3, 3}, {5, 2}
        }, d = {
                {2, 3}, {2, 4}, {2, 5}
        };
//        System.out.println(Arrays.toString(closestRoom(a, c)));
        System.out.println(Arrays.toString(closestRoom(b, d)));
    }

    public static int[] closestRoom(int[][] rooms, int[][] queries) {
        List<Room> list = new ArrayList<>();
        for (int i = 0; i < rooms.length; i++) {
            list.add(new Room(rooms[i][0], rooms[i][1], i + 1));
        }
        list.sort((a, b) -> a.size == b.size ? b.id - a.id : a.size - b.size);

        for (int i = 0; i < queries.length; i++) {

        }

        return new int[1];
    }

    private static class Room {
        int id;
        int size;
        int index;
        public Room(int id, int size, int index) {
            this.id = id;
            this.size = size;
            this.index = index;
        }
    }

}
