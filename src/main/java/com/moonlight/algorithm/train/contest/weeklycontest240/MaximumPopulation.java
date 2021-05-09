package com.moonlight.algorithm.train.contest.weeklycontest240;

import java.util.*;

/**
 * 给你一个二维整数数组 logs ，其中每个 logs[i] = [birthi, deathi] 表示第 i 个人的出生和死亡年份。
 * 年份 x 的 人口 定义为这一年期间活着的人的数目。第 i 个人被计入年份 x 的人口需要满足：x 在闭区间 [birthi, deathi - 1] 内。注意，人不应当计入他们死亡当年的人口中。
 * 返回 人口最多 且 最早 的年份。
 *
 * 输入：logs = [[1993,1999],[2000,2010]]  输出：1993
 * 解释：人口最多为 1 ，而 1993 是人口为 1 的最早年份。
 *
 * 输入：logs = [[1950,1961],[1960,1971],[1970,1981]]   输出：1960
 * 解释： 人口最多为 2 ，分别出现在 1960 和 1970 。其中最早年份是 1960 。
 *
 * 提示：1 <= logs.length <= 100   1950 <= birthi < deathi <= 2050
 *
 * @ClassName MaximumPopulation
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/9 10:34
 * @Version V1.0
 **/
public class MaximumPopulation {

    public static void main(String[] args) {
        int[][] a = {
                {1993, 1999}, {2000, 2010}
        }, b = {
                {1950, 1961}, {1960, 1971}, {1970, 1981}
        }, c = {
                {1950, 1963}, {1961, 1988}, {1970, 1980}, {1981, 1987}
        };
        System.out.println(maximumPopulation(a));
        System.out.println(maximumPopulation(b));
        System.out.println(maximumPopulation(c));
    }

    public static int maximumPopulation(int[][] logs) {
        int[] year = new int[2050 - 1950];

        for (int[] a : logs) {
            for (int i = a[0]; i < a[1]; i++) {
                year[i - 1950]++;
            }
        }
        int ans = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0; i < year.length; i++) {
            if (year[i] > cnt) {
                ans = 1950 + i;
                cnt = year[i];
            }
        }

        return ans;
    }

}
