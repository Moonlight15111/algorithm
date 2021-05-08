package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/permutation-in-string/
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"  输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 输入: s1= "ab" s2 = "eidboaoo"  输出: False
 *
 * @author Moonlight
 * @date 2021/5/8 12:26
 */
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(backtrack("ab", "eidbaooo") + ", " + backtrack12("ab", "eidbaooo") + ", " + slidingWindow("ab", "eidbaooo"));
        System.out.println(backtrack("ab", "eidboaoo") + ", " + backtrack12("ab", "eidboaoo") + ", " + slidingWindow("ab", "eidboaoo"));
        System.out.println(backtrack("ab", "ab") + ", " + backtrack12("ab", "ab") + ", " + slidingWindow("ab", "ab"));
    }

    public static boolean slidingWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        // 其实只要关注在s2上是否有某个区间上的字符出现的种类和数量和 s1 一致
        int[] cnt1 = new int[26], cnt2 = new int[26];;
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }

        return false;
    }

    public static boolean backtrack12(String s1, String s2) {
        // time out
        boolean[] visible = new boolean[s1.length()];

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);

       return backtrack12(chars, visible, new StringBuilder(), s2);
    }

    private static boolean backtrack12(char[] chars, boolean[] visible, StringBuilder builder, String s2) {
        if (builder.length() == chars.length) {
            return s2.contains(builder.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visible[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !visible[i - 1]) {
                    continue;
                }
                visible[i] = true;
                builder.append(chars[i]);
                if (backtrack12(chars, visible, builder, s2)) {
                    return true;
                }
                visible[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
        return false;
    }


    public static boolean backtrack(String s1, String s2) {
        // out of memory limit
        List<String> list = new ArrayList<>();

        boolean[] visible = new boolean[s1.length()];

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);

        backtrack(chars, visible, new StringBuilder(), list);

        for (String s : list) {
            if (s2.contains(s)) {
                return true;
            }
        }

        return false;
    }

    private static void backtrack(char[] chars, boolean[] visible, StringBuilder builder, List<String> list) {
        if (builder.length() == chars.length) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!visible[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !visible[i - 1]) {
                    continue;
                }
                builder.append(chars[i]);
                visible[i] = true;
                backtrack(chars, visible, builder, list);
                visible[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

}
