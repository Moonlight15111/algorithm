package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/programmable-robot/
 *
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，
 * 机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *     U: 向y轴正方向移动一格
 *     R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 * 输入：command = "URR", obstacles = [], x = 3, y = 2  输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 *
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2  输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 *
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2  输出：true
 *
 * @author Moonlight
 */
public class Robot {

    public static void main(String[] args) {
        System.out.println(robot("URR", new int[][]{}, 3, 2));
        System.out.println(robot("URR", new int[][]{{2, 2}}, 3, 2));
        System.out.println(robot("URR", new int[][]{{4, 2}}, 3, 2));
    }

    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        Map<Integer, Set<Integer>> obsMap = new HashMap<>();
        for (int[] ob : obstacles) {
            if (obsMap.containsKey(ob[0])) {
                obsMap.get(ob[0]).add(ob[1]);
            } else {
                Set<Integer> orDefault = obsMap.getOrDefault(ob[0], new HashSet<>());
                orDefault.add(ob[1]);
                obsMap.put(ob[0], orDefault);
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : command.toCharArray()) {
            queue.add(c);
        }

        int r = 0, c = 0;
        while (!queue.isEmpty()) {
            if (r > x || c > y) {
                return false;
            }
            if (obsMap.get(r) != null && obsMap.get(r).contains(c)) {
                return false;
            }
            if (r == x && c == y) {
                return true;
            }
            char poll = queue.poll();
            if (poll == 'R') {
                r++;
            } else {
                c++;
            }
            queue.add(poll);
        }
        return false;
    }

}
