package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/simplified-fractions/
 * <p>
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 * <p>
 * 输入：n = 2  输出：["1/2"]
 * <p>
 * 输入：n = 3  输出：["1/2","1/3","2/3"]
 * <p>
 * 输入：n = 4  输出：["1/2","1/3","1/4","2/3","3/4"]
 * 解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。
 * <p>
 * 输入：n = 1  输出：[]
 *
 * @author Moonlight
 */
public class SimplifiedFractions {

    public static void main(String[] args) {
        System.out.println(simplifiedFractions(2));
        System.out.println(simplifiedFractions(3));
        System.out.println(simplifiedFractions(4));
        System.out.println(simplifiedFractions(1));
    }

    public static List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (div(i, j) == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }

    public static int div(int i, int j) {
        if (j == 0) {
            return i;
        }
        return div(j, i % j);
    }

}
