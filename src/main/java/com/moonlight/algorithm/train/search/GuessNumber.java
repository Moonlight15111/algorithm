package com.moonlight.algorithm.train.search;

/**
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 *
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 *
 * 输入：n = 10, pick = 6
 * 输出：6
 *
 * 输入：n = 1, pick = 1
 * 输出：1
 *
 * @author Moonlight
 */
public class GuessNumber {

//    public int guessNumber(int n) {
//        int left = 1, right = n, mid;
//        while (left < right) {
//            mid = left + ((right - left) >> 1);
//            if (guess(mid) <= 0) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

}
