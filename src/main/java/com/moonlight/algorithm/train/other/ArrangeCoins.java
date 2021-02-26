package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/arranging-coins/
 *
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 *
 * n = 5
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * 因为第三行不完整，所以返回2.
 *
 * n = 8
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * 因为第四行不完整，所以返回3.
 *
 * @author Moonlight
 * @date 2021/2/26 12:15
 */
public class ArrangeCoins {

    public static void main(String[] args) {
        System.out.println(arrangeCoins(1));
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(16));
    }

    public static int arrangeCoins(int n) {
        if (n <= 0) {
            return 0;
        }

        int i = 0;
        while (n > i) {
            n -= i;
            i += 1;

            if (i + 1 > n - i) {
                return i;
            }
        }

        return i - 1;
    }

}
