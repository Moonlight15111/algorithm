package com.moonlight.algorithm.train.dp;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/nim-game/
 *`你和你的朋友，两个人一起玩 Nim 游戏：
 *   桌子上有一堆石头。你们轮流进行自己的回合，你作为先手。每一回合，轮到的人拿掉 1 - 3 块石头。
 *   拿掉最后一块石头的人就是获胜者。
 * 假设你们每一步都是最优解。请编写一个函数，来判断你是否可以在给定石头数量为 n 的情况下赢得游戏。
 * 如果可以赢，返回 true；否则，返回 false 。
 *
 * 输入：n = 4
 * 输出：false
 * 解释：如果堆中有 4 块石头，那么你永远不会赢得比赛；
      因为无论你拿走 1 块、2 块 还是 3 块石头，最后一块石头总是会被你的朋友拿走。
 * 输入：n = 1
 * 输出：true
 *
 * @author Moonlight
 * @date 2021/1/16 10:17
 */
public class CanWinNim {

    public static void main(String[] args) {
        System.out.println(canWinNim(41));
        System.out.println(canWinNim123(41));
    }

    public static boolean canWinNim123(int n) {
        return n % 4 != 0;
    }

    public static boolean canWinNim(int n) {
        return first(n) || second(n);
    }

    private static boolean second(int n) {
        if (n < 4) {
            return true;
        }
        return !(first(n - 1) && first(n - 2) && first(n - 3));
    }

    private static boolean first(int n) {
        if (n <= 0) {
            return false;
        }
        if (n <  4) {
            return true;
        }
        // 对于先手有n个石头，后手就有n - 1、n - 2、n - 3三种石头
        // 所以对于先手而言，只要后手有一种选择可以赢，那么就是必输的
        return !(second(n - 1) && second(n - 2) && second(n - 3));
    }

}
