package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/24-game/
 *
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 *
 * 输入: [4, 1, 8, 7]  输出: True
 * 解释: (8-4) * (7-1) = 24
 *
 * 输入: [1, 2, 1, 2]  输出: False
 *
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 *
 *
 */
public class JudgePoint24 {

    public static void main(String[] args) {
        int[] a = {4, 1, 8, 7}, b = {1, 2, 1, 2}, c = {7, 4, 1, 9};

        System.out.println(judgePoint24(a));
        System.out.println(judgePoint24(b));
        System.out.println(judgePoint24(c));
    }

    static double EPSLON = 1e-6;

    public static boolean judgePoint24(int[] cards) {
        return backtrack(new double[]{cards[0], cards[1], cards[2], cards[3]});
    }

    public static boolean backtrack(double[] cards) {
        if (cards.length == 1) {
            return Math.abs(cards[0] - 24) < EPSLON;
        }
        int len = cards.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                double[] next = new double[len - 1];
                for (int k = 0, idx = 0; k < len; k++) {
                    if (k != i && k != j) {
                        next[idx++] = cards[k];
                    }
                }
                for (double n : calculate(cards[i], cards[j])) {
                    next[next.length - 1] = n;
                    if (backtrack(next)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static List<Double> calculate(double a, double b) {
        List<Double> ans = new ArrayList<>();
        ans.add(a + b);
        ans.add(a - b);
        ans.add(b - a);
        ans.add(a * b);
        if (Math.abs(a) > EPSLON) {
            ans.add(b / a);
        }
        if (Math.abs(b) > EPSLON) {
            ans.add(a / b);
        }
        return ans;
    }

}
