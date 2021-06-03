package com.moonlight.algorithm.train.dp;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 输入：[5,5,5,10,20]   输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 *
 * 输入：[5,5,10]   输出：true
 *
 * 输入：[10,10]    输出：false
 *
 * 输入：[5,5,10,10,20]  输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *
 * @author Moonlight
 * @date 2021/6/3 13:16
 */
public class LemonadeChange {

    public static void main(String[] args) {
        int[] a = {5, 5, 5, 10, 20}, b = {5, 5, 10}, c = {10, 10}, d = {5, 5, 10, 10, 20};
        // true
        System.out.println(lemonadeChange(a));
        // true
        System.out.println(lemonadeChange(b));
        // false
        System.out.println(lemonadeChange(c));
        // false
        System.out.println(lemonadeChange(d));
    }

    public static boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) {
            return true;
        }
        if (bills[0] != 5) {
            return false;
        }
        int five = 0, ten = 0;
        for (int n : bills) {
            if (n == 5) {
                five++;
            } else if (n == 10) {
                if (five >= 1) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (five >= 1 && ten >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
