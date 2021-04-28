package com.moonlight.algorithm.train.search;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 输入：c = 5   输出：true   解释：1 * 1 + 2 * 2 = 5
 *
 * 输入：c = 3   输出：false
 *
 * 输入：c = 4   输出：true
 *
 * 输入：c = 2   输出：true
 *
 * 输入：c = 1   输出：true
 *
 * @author Moonlight
 * @date 2021/4/28 13:07
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(0));
    }

    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c), sum = 0;
        while (left <= right) {
            sum = left * left + right * right;
            if (sum < c) {
                left++;
            } else if (sum > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

}
