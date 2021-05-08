package com.moonlight.algorithm.train.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/distribute-candies/
 *
 * 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 * 你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 *
 * 输入: candies = [1,1,2,2,3,3]   输出: 3
 * 解析: 一共有三种种类的糖果，每一种都有两个。
 *       最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
 *
 * 输入: candies = [1,1,2,3]  输出: 2
 * 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
 *
 * @author Moonlight
 * @date 2021/5/8 12:09
 */
public class DistributeCandies {

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3}, b = {1, 1, 2, 3};
        System.out.println(distributeCandies(a));
        System.out.println(distributeCandies(b));
    }

    public static int distributeCandies(int[] candyType) {
        // 求的是妹妹可以得到的糖果种类的最多种类数
        // 所以理论上可以得到的最多的就是糖果种类的个数
        // 但是需要平均分配且数组长度为偶数长度，所以要折中在 理论上最多的种类的个数 和 糖果数量 / 2 上取最小值
        Set<Integer> set = new HashSet<>();
        for (int c : candyType) {
            set.add(c);
        }
        return Math.min(candyType.length / 2, set.size());
    }

}