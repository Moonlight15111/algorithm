package com.moonlight.algorithm.train.contest.weeklycontest241;

import java.util.Arrays;

/**
 * 给你一个二进制字符串 s ，现需要将其转化为一个 交替字符串 。请你计算并返回转化所需的 最小 字符交换次数，如果无法完成转化，返回 -1 。
 * 交替字符串 是指：相邻字符之间不存在相等情况的字符串。例如，字符串 "010" 和 "1010" 属于交替字符串，但 "0100" 不是。
 * 任意两个字符都可以进行交换，不必相邻 。
 *
 * 输入：s = "111000"  输出：1
 * 解释：交换位置 1 和 4："111000" -> "101010" ，字符串变为交替字符串。
 *
 * 输入：s = "010"  输出：0
 * 解释：字符串已经是交替字符串了，不需要交换。
 *
 * 输入：s = "1110"  输出：-1
 *
 * @ClassName MinSwaps
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/5/16 11:09
 * @Version V1.0
 **/
public class MinSwaps {

    public static void main(String[] args) {
        String a = "111000", b = "010", c = "1110", d = "100", e = "01000";

        System.out.println(minSwaps(a));
        System.out.println(minSwaps(b));
        System.out.println(minSwaps(c));
        System.out.println(minSwaps(d));
        System.out.println(minSwaps(e));
    }

    public static int minSwaps(String s) {
        if (s.length() == 1) {
            return 0;
        }
        // 0 开头还是 1 开头
        char[] chars = s.toCharArray(), carr0 = new char[s.length()], carr1 = new char[s.length()];
        Arrays.fill(carr1, '0');
        Arrays.fill(carr0, '0');
        for (int i = 0; i < s.length(); i += 2) {
            carr0[i] = '1';
        }
        for (int i = 1; i < s.length(); i += 2) {
            carr1[i] = '1';
        }
        int ans = Math.min(cnt(carr0, chars), cnt(carr1, chars));
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int cnt(char[] carr1, char[] s) {
        int cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < carr1.length; i++) {
            if (carr1[i] != s[i]) {
                if (carr1[i] == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }
        return cnt0 == cnt1 ? cnt0 : Integer.MAX_VALUE;
    }

}
