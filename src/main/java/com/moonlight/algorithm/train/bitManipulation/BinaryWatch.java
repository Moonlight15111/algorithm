package com.moonlight.algorithm.train.bitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/binary-watch/
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 * 超过表示范围（小时 0-11，分钟 0-59）的数据将会被舍弃，也就是说不会出现 "13:00", "0:61" 等时间。
 * @author Moonlight
 * @date 2020/12/19 9:52
 */
public class BinaryWatch {

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(0));
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();

        // h < 12 && min < 60  求num个灯组合的情况下有多少种可能
        // 即 h.bitCount + min.bitCount = num
        for (int h = 0; h < 12; h++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount(h) + Integer.bitCount(min) == num) {
                    result.add(buildTime(h, min));
                }
            }
        }

        return result;
    }

    public static String buildTime(int h, int min) {
        return String.valueOf(h) + ":" +
                (min >= 10 ? min : "0" + min);
    }

}