package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * https://leetcode-cn.com/problems/perfect-number/
 *
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 *
 * 输入：28   输出：True
 * 解释：28 = 1 + 2 + 4 + 7 + 14
 *
 * 输入：num = 6  输出：true
 *
 * 输入：num = 496  输出：true
 *
 * 输入：num = 8128  输出：true
 *
 * 输入：num = 2  输出：false
 *
 * @author Moonlight
 * @date 2021/7/19 16:19
 */
public class CheckPerfectNumber {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
        System.out.println(checkPerfectNumber(6));
        System.out.println(checkPerfectNumber(496));
        System.out.println(checkPerfectNumber(8128));
        System.out.println(checkPerfectNumber(2));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 1 || num == 2) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * i <= num ; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum == num;
    }

}
