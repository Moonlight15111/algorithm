package com.moonlight.algorithm.train.greedy;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/calculate-money-in-leetcode-bank/
 * <p>
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 * <p>
 * 输入：n = 4         输出：10       解释：第 4 天后，总额为 1 + 2 + 3 + 4 = 10 。
 * <p>
 * 输入：n = 10        输出：37
 * 解释：第 10 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37 。注意到第二个星期一，Hercy 存入 2 块钱。
 * <p>
 * 输入: n = 14        输出:
 * 解释：第 14 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) = 63 。
 * <p>
 * 输入：n = 20        输出：96
 * 解释：第 20 天后，总额为 (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96 。
 *
 * @author Moonlight
 * @date 2021/3/3 14:16
 */
public class CalculateMoneyInLeetCodeBank {

    public static void main(String[] args) {
        System.out.println(totalMoney(20));
    }

    public static int totalMoney(int n) {
        int sum = 0, weeks = n / 7, days = n % 7;
        // 第一周: 28 + 7 * 0 第二周: 28 + 7 * 1 第三周: 28 + 7 * 2 .... => 第 x 周 = 28 + 7 * (x - 1) => 21 + 7 * x
        for (int i = 1; i <= weeks; i++) {
            sum += (21 + 7 * i);
        }
        // 每周上涨一块后每天加一块
        if (days != 0) {
            for (int i = 1; i <= days; i++) {
                sum += weeks + i;
            }
        }
        return sum;
    }

}
