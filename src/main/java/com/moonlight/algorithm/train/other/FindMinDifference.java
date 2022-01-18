package com.moonlight.algorithm.train.other;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-time-difference/
 *
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 *
 * 输入：timePoints = ["23:59","00:00"] 输出：1
 *
 * 输入：timePoints = ["00:00","23:59","00:00"] 输出：0
 *
 * @author Moonlight
 */
public class FindMinDifference {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>(), b = new ArrayList<>();
        a.add("23:59");
        a.add("00:00");
        b.add("00:00");
        b.add("23:59");
        b.add("00:00");

        System.out.println(findMinDifference(a));
        System.out.println(findMinDifference(b));
    }

    public static int findMinDifference(List<String> timePoints) {
        timePoints.sort(null);
        int ans = Integer.MAX_VALUE, size = timePoints.size();
        int first = convertMin(timePoints.get(0)), prev = first, cur;
        for (int i = 1; i < size; i++) {
            cur = convertMin(timePoints.get(i));
            ans = Math.min(ans, cur - prev);
            prev = cur;
        }
        return Math.min(ans, first + 1440 - prev);
    }

    private static int convertMin(String s) {
       return  ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0')) * 60 + (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
    }

}
