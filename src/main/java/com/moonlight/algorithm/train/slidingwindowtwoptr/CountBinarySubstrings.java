package com.moonlight.algorithm.train.slidingwindowtwoptr;

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 *
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 * 重复出现的子串要计算它们出现的次数。
 *
 * 输入: "00110011"  输出: 6
 * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
 *       请注意，一些重复出现的子串要计算它们出现的次数。
 *       另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
 *
 * 输入: "10101"  输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 *
 * @ClassName CountBinarySubstrings
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/4 11:59
 * @Version V1.0
 **/
public class CountBinarySubstrings {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings("10101"));
    }

    public static int countBinarySubstrings(String s) {
        int i = 0, ans = 0, prevCnt = 0, len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            int cnt = 0;
            while (i < len && s.charAt(i) == c) {
                i++;
                cnt++;
            }
            ans += Math.min(cnt, prevCnt);
            prevCnt = cnt;
        }
        return ans;
    }

}
