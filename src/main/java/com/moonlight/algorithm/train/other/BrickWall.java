package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/brick-wall/
 *
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
 * 你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 *
 * 输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]   输出：2
 *
 * 输入：wall = [[1],[1],[1]]  输出：3
 *
 * @ClassName BrickWall
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/2 12:23
 * @Version V1.0
 **/
public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        // 其实就是找缝，穿过的砖头最少的数量其实就等价于穿过的缝最多的数量
        // 以最左为基准，看每一条缝到最左的距离有多少
        // 比如: 1 2 2 1 =》 它的缝隙分布位置为： 1  3  5
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size() - 1; i++) {
                sum += w.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int ans = n;
        for (int key : map.keySet()) {
            ans = Math.min(ans, n - map.get(key));
        }
        return ans;
    }

}
