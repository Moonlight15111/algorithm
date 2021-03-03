package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 *
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 * 输入：n = 12    输出：5            输入：n = 13    输出：6
 *
 * @author Moonlight
 * @date 2021/3/3 9:22
 */
public class CountDigitOne {

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }

//    public static int countDigitOne123(int n) {
//
//    }

    public static int countDigitOne(int n) {
        // 超时
        int count = 0, tmp;
        for (int i = 1; i <= n; i++) {
            tmp = i;
            while (tmp != 0) {
                if (tmp % 10 == 1) {
                    count++;
                }
                tmp /= 10;
            }
        }
        return count;
    }

}
