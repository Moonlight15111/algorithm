package com.moonlight.algorithm.train.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/minimum-time-difference/
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 输入：timePoints = ["23:59","00:00"]  输出：1
 *
 * 输入：timePoints = ["00:00","23:59","00:00"]  输出：0
 *
 * @author Moonlight
 * @date 2021/5/8 9:57
 */
public class FindMinDifference {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("00:00");
        list.add("23:59");
        list.add("00:00");
        System.out.println(findMinDifference(list));
    }

    public static int findMinDifference(List<String> timePoints) {
        int[] times = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            times[i] = parse(timePoints.get(i));
        }
        Arrays.sort(times);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < times.length; i++) {
            min = Math.min(min, times[i] - times[i - 1]);
        }
        // 00:00 - 23:59 ==> 1440 - 1439
        return Math.min(min, 1440 + times[0] - times[times.length - 1]);
    }

    public static int parse(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

}
