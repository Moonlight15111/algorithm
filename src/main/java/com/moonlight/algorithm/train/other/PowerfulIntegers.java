package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/powerful-integers/
 *
 * 给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。
 * 如果某一整数可以表示为 x^i + y^j ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。
 * 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。
 *
 * 1 <= x, y <= 100
 * 0 <= bound <= 10^6
 *
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *
 * @author Moonlight
 * @date 2022-05-05 14:47
 */
public class PowerfulIntegers {

    public static void main(String[] args) {
        System.out.println(powerfulIntegers(2, 3, 10));
        System.out.println(powerfulIntegers(3, 5, 15));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        // 由提示可知 10^6 为最大
        // 考虑到x，y 为2的情况, 10^6 < 2^20
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 21 && Math.pow(x, i) <= bound; i++) {
            for (int j = 0; j < 21 && Math.pow(y, j) <= bound; j++) {
                int sum = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if (sum <= bound) {
                    set.add(sum);
                }
            }
        }
        return new ArrayList<>(set);
    }

}