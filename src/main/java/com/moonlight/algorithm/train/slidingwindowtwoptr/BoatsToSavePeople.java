package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/boats-to-save-people/
 *
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 输入：people = [1,2], limit = 3    输出：1   解释：1 艘船载 (1, 2)
 *
 * 输入：people = [3,2,2,1], limit = 3  输出：3  解释：3 艘船分别载 (1, 2), (2) 和 (3)
 *
 * 输入：people = [3,5,3,4], limit = 5  输出：4   解释：4 艘船分别载 (3), (3), (4), (5)
 *
 * @author Moonlight
 * @date 2021/3/3 17:45
 */
public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] a = {1, 2}, b = {3, 2, 2, 1}, c = {3, 5, 3, 4}, d = {5, 1, 4, 2};
        System.out.println(numRescueBoats(a, 3));
        System.out.println(numRescueBoats(b, 3));
        System.out.println(numRescueBoats(c, 5));
        System.out.println(numRescueBoats(d, 6));
    }

    public static int numRescueBoats(int[] people, int limit) {
        // 先进行一个排序
        // 然后双指针两头推进，最重的和最轻的人进行组合,能搭两个就搭两个并且左指针往前进,否则就只搭最重的
        Arrays.sort(people);

        int res = 0;
        for (int i = people.length - 1, j = 0; i >= j; i--) {
            if (people[i] + people[j] <= limit) {
                j++;
            }
            res++;
        }

        return res;
    }

}
