package com.moonlight.algorithm.train.bitManipulation;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * 给你一个非负整数 num ，请你返回将它变成 0 所需要的步数。 如果当前数字是偶数，你需要把它除以 2 ；否则，减去 1
 * 输入：num = 8
 * 输出：4
 * 解释：
 * 步骤 1） 8 是偶数，除以 2 得到 4 。
 * 步骤 2） 4 是偶数，除以 2 得到 2 。
 * 步骤 3） 2 是偶数，除以 2 得到 1 。
 * 步骤 4） 1 是奇数，减 1 得到 0
 * @author Moonlight
 * @date 2020/12/18 15:40
 */
public class NumberOfSteps {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps (int num) {
        if (num == 0) {
            return 0;
        }
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            res++;
        }
        return res;
    }

}
