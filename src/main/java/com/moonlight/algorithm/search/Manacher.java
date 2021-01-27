package com.moonlight.algorithm.search;

import java.util.Arrays;

/**
 * 最长回文长度
 * @ClassName Manacher
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/1/27 21:45
 * @Version V1.0
 **/
public class Manacher {

    public static void main(String[] args) {
        System.out.println(maxPLen("abcdeedcba"));
        System.out.println(manacher("abcdeedcba"));
    }

    public static int manacher(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()) {
            str.append("#").append(c);
        }
        String s1 = str.append("#").toString();
        // 回文半径数组
        int[] pArr = new int[s1.length()];
        // 回文最长右边界中心点
        int cert = 0;
        // 回文最长右边界的下一个位置，即第一个违规的位置
        int longestRight = 0;
        int max = 0;
        for (int i = 0; i < s1.length(); i++) {
            // 大于则 说明 i 在 longestRight中，则取当前点的对称点与当前位置至最右边界之间最小的值
            // 小于等于则说明i不在longestRight范围中，则最少可以确定一个位置是不需要验证是否一样的
            pArr[i] = longestRight > i ? Math.min(pArr[2 * cert - i], longestRight - i) : 1;
            // 左右不越界，看能不能往外扩
            while (i + pArr[i] < s1.length() && i - pArr[i] > -1) {
                if (s1.charAt(i + pArr[i]) == s1.charAt(i - pArr[i])) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            // 更新回文最长右边界和中心点
            if (i + pArr[i]  > longestRight) {
                longestRight = i + pArr[i];
                cert = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static int maxPLen(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()) {
            str.append("#").append(c);
        }
        String s1 = str.append("#").toString();
        int[] pArr = new int[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            int prev = i - 1, ahead = i + 1, len = 1;
            while (prev >= 0 && ahead < s1.length() && s1.charAt(prev) == s1.charAt(ahead)) {
                prev--;
                ahead++;
                len++;
            }
            pArr[i] = len;
        }
        int res = 0;
        for (int i = 0; i < s1.length() ; i++) {
            res = Math.max(pArr[i], res);
        }
        return res - 1;
    }

}
