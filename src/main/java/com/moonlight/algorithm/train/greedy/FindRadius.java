package com.moonlight.algorithm.train.greedy;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/heaters/
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 输入: houses = [1,2,3], heaters = [2]  输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 * 输入: houses = [1,2,3,4], heaters = [1,4]  输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 * @author Moonlight
 * @date 2021/4/22 13:11
 */
public class FindRadius {

    public static void main(String[] args) {
        int[] a = {1, 2, 3}, b = {1, 2, 3, 4}, c = {1, 5};
        int[] x = {2}, y = {1, 4}, z = {2};
        System.out.println(findRadius(a, x));
        System.out.println(findRadius(b, y));
        System.out.println(findRadius(c, z));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // 找出每个房子与它最近的供暖器的距离是多少
        // 然后比较每个房子最近距离，最大的就是答案

        int ans = 0, right = 0;
        for (int h : houses) {
            while (right < heaters.length - 1 &&  Math.abs(heaters[right] - h) >= Math.abs(heaters[right + 1] - h)) {
                right++;
            }
            ans =  Math.max(ans, Math.abs(heaters[right] - h));
        }

        return ans;
    }

}
