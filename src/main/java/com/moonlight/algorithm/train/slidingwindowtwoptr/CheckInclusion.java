package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/MPnaiL/
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"  输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 输入: s1= "ab" s2 = "eidboaoo"  输出: False
 *
 * @ClassName CheckInclusion
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/17 12:05
 * @Version V1.0
 **/
public class CheckInclusion {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] a = new int[26], b = new int[26];
        for (int i = 0; i < n; i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a, b)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            b[s2.charAt(i) - 'a']++;
            b[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(a, b)) {
                return true;
            }
        }
        return false;
    }

}
