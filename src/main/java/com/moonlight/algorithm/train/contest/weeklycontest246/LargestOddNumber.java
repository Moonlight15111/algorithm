package com.moonlight.algorithm.train.contest.weeklycontest246;

/**
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，
 * 并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * 子字符串 是字符串中的一个连续的字符序列。
 *
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 *
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 *
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 *
 * @ClassName LargestOddNumber
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/20 10:36
 * @Version V1.0
 **/
public class LargestOddNumber {

    public static void main(String[] args) {
        System.out.println(largestOddNumber("52"));
        System.out.println(largestOddNumber("4206"));
        System.out.println(largestOddNumber("35427"));
        System.out.println(largestOddNumber("2925272"));
    }

    public static String largestOddNumber(String num) {
        int n = num.length();
        char[] chars = num.toCharArray();
        int i = n - 1;
        while (i >= 0 && ((chars[i] - '0') & 1) == 0)
            i--;
        if (i == -1)
            return "";
        return num.substring(0, i + 1);
    }

}
