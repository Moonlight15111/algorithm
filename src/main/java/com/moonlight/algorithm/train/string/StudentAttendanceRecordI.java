package com.moonlight.algorithm.train.string;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *   1. 'A' : Absent，缺勤
 *   2. 'L' : Late，迟到
 *   3. 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 输入: "PPALLP"  输出: True
 *
 * 输入: "PPALLL"  输出: False
 *
 * @author Moonlight
 * @date 2021/5/8 10:55
 */
public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLP"));
        System.out.println(checkRecord("PPALLL"));
    }

    public static boolean checkRecord(String s) {
        int ac = 0, lc = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                ac++;
                lc = lc > 2 ? lc : 0;
            } else if (c == 'L') {
                lc++;
            } else {
                lc = lc > 2 ? lc : 0;
            }
        }
        return ac < 2 && lc < 3;
    }

}