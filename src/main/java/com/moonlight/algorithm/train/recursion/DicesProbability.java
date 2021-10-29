package com.moonlight.algorithm.train.recursion;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
 *
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * @author Moonlight
 */
public class DicesProbability {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(1)));
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    public static double[] dicesProbability(int n) {
        // n 个骰子的结果总共有 6 ^ n 种, 结果的数据范围在[n, 6 * n]之间, 不重复的结果有 (6 * n) - (n - 1) 种 => 5n + 1
        // 每种结果出现的概率: 每种结果出现的次数 / 6 ^ n
        double p = 1 / (double) 6;
        if (n == 1) {
            double[] ans = new double[6];
            Arrays.fill(ans, p);
            return ans;
        }
        double[] next = dicesProbability(n - 1);
        double[] ans = new double[5 * n + 1];
        for (int i = 0; i < next.length; i++) {
            for (int j = 1; j < 7; j++) {
                ans[j - 1 + i] += next[i] * p;
            }
        }
        return ans;
    }


}
