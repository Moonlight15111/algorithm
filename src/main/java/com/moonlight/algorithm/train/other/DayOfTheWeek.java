package com.moonlight.algorithm.train.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * https://leetcode-cn.com/problems/day-of-the-week/
 *
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 *
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 *
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *
 * @ClassName DayOfTheWeek
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/3 11:27
 * @Version V1.0
 **/
public class DayOfTheWeek {

    public static void main(String[] args) throws ParseException {
        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(15, 8, 1993));
    }

    public static String dayOfTheWeek(int day, int month, int year) throws ParseException {
        int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        int ans = 4;
        for (int i = 1971; i < year; i++) {
            boolean isLeap = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            ans += isLeap ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            ans += nums[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) ans++;
        }
        ans += day;
        return week[ans % 7];
//        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        String date = year + "-" + month + "-" + day;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(sdf.parse(date));
//        return week[instance.get(Calendar.DAY_OF_WEEK) - 1];
    }

}
