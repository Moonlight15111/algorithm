package com.moonlight.algorithm.train.other;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/na-ying-bi/
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 *
 * @author Moonlight
 * @date 2021/1/16 17:49
 */
public class MinCount {

    public static void main(String[] args) {
        System.out.println(minCount(new int[]{2, 3, 10}));
    }

    public static int minCount(int[] coins) {
        int res = 0;
        for (int c : coins) {
            res += c / 2;
            res += c % 2;
        }
        return res;
    }

}
