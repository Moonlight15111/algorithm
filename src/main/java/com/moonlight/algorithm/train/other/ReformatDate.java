package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/reformat-date/
 *
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 *   Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 *   Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 *   Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 *   YYYY 表示 4 位的年份。
 *   MM 表示 2 位的月份。
 *   DD 表示 2 位的天数。
 *
 * 输入：date = "20th Oct 2052"  输出："2052-10-20"
 *
 * 输入：date = "6th Jun 1933"  输出："1933-06-06"
 *
 * 输入：date = "26th May 1960"  输出："1960-05-26"
 *
 * @author Moonlight
 */
public class ReformatDate {

    public static void main(String[] args) {
        System.out.println(reformatDate("20th Oct 2052"));
        System.out.println(reformatDate("6th Jun 1933"));
        System.out.println(reformatDate("26th May 1960"));
    }

    public static String reformatDate(String date) {
        String[] m = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            map.put(m[i - 1], i);
        }

        StringBuilder ans = new StringBuilder();

        String[] split = date.split(" ");

        ans.append(split[2]).append("-");

        if (map.get(split[1]) < 10) {
            ans.append("0");
        }
        ans.append(map.get(split[1])).append("-");

        int d = Integer.parseInt(split[0].substring(0, split[0].length() - 2));
        if (d < 10) {
            ans.append("0");
        }

        return ans.append(d).toString();
    }

}