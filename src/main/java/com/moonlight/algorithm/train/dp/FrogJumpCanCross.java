package com.moonlight.algorithm.train.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/frog-jump/
 *
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 * 开始时，青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 * 输入：stones = [0,1,3,5,6,8,12,17]   输出：true
 * 解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子,
 * 接着 跳 2 个单位到第 4 块石子, 然后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子,
 * 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。
 *
 * 输入：stones = [0,1,2,3,4,8,9,11]    输出：false
 * 解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。
 *
 * @author Moonlight
 * @date 2021/4/29 12:51
 */
public class FrogJumpCanCross {

    public static void main(String[] args) {
        int[] a = {0, 1, 3, 5, 6, 8, 12, 17}, b = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(recursion(a) + ", " + memory(a));
        System.out.println(recursion(b) + ", " + memory(b));
    }

    public static boolean dp(int[] stones) {
        // todo dp
        return false;
    }

    public static boolean memory(int[] stones) {
        if (stones.length == 1 || (stones.length == 2 && stones[1] - stones[0] == 0)) {
            return true;
        }
        Map<Integer, Map<Integer, Boolean>> map = new HashMap<>();
        return process(stones, 0, 0, map);
    }
    private static boolean process(int[] stones, int index, int step, Map<Integer, Map<Integer, Boolean>> map) {
        if (map.containsKey(index)) {
            if (map.get(index).containsKey(step)) {
                return map.get(index).get(step);
            }
        }
        for (int i = index + 1; i < stones.length; i++) {
            int dist = stones[i] - stones[index];
            if (dist < step - 1) {
                continue;
            }
            if (dist > step + 1) {
                break;
            }
            if (process(stones, i, dist, map)) {
                Map<Integer, Boolean> m = new HashMap<>();
                if (map.containsKey(index)) {
                    m = map.get(index);
                }
                m.put(step, true);
                map.put(index, m);
                return true;
            }
        }
        Map<Integer, Boolean> m = new HashMap<>();
        if (map.containsKey(index)) {
            m = map.get(index);
        }
        m.put(step, index == stones.length - 1);
        map.put(index, m);
        return index == stones.length - 1;
    }

    public static boolean recursion(int[] stones) {
        if (stones.length == 1 || (stones.length == 2 && stones[1] - stones[0] == 0)) {
            return true;
        }
        // timeout

        // 能跳的距离受限于它上次跳的距离，也就是只能在跳 k、k - 1、k + 1 个单位之间选择
        // 如果来到了 i 位置，且上次跳了 k 个单位，则它本次需要判断的就是 在前面那些大于 i 的位置上，有没有哪个位置是它跳 k 个单位 或者 跳 k - 1 个单位 或者 跳 k + 1 个单位能达到的
        // 如果当前 i 位置 和 i + 1 位置 相隔的距离小于 k - 1，那么就说明距离太近了，不能跳， 如果 大于 k + 1，就说明距离太远了，跳不到

        // 出生就在 0 号位置，所以上次根本就不需要跳
        return process(stones, 0, 0);
    }

    // index => 当前来到了哪个位置   step => 上次跳了多少个距离
    private static boolean process(int[] stones, int index, int step) {
        for (int i = index + 1; i < stones.length; i++) {
            int dist = stones[i] - stones[index];
            if (dist < step - 1) {
                continue;
            }
            if (dist > step + 1) {
                break;
            }
            if (process(stones, i, dist)) {
                return true;
            }
        }
        return index == stones.length - 1;
    }

}
