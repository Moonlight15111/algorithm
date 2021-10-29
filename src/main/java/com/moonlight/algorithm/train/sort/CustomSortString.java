package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/custom-sort-string/
 *
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。
 * 更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * 返回任意一种符合条件的字符串T。
 *
 * 输入: S = "cba"  T = "abcd"
 * 输出: "cbad"
 * 解释:  S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 *       由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 *
 * @author Moonlight
 */
public class CustomSortString {

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd") + ", " + cnt("cba", "abcd"));
    }

    public static String cnt(String order, String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : order.toCharArray()) {
            for (int i = 0; i < cnt[c - 'a']; i++) {
                ans.append(c);
            }
            cnt[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            while (cnt[i] > 0) {
                ans.append((char)(i + 'a'));
                cnt[i]--;
            }
        }
        return ans.toString();
    }

    public static String customSortString(String order, String s) {
        StringBuilder ans = new StringBuilder();
        char[] orderCharArr = order.toCharArray(), chars = s.toCharArray();
        Arrays.sort(chars);
        for (char c : orderCharArr) {
            int j = 0;
            while (j < chars.length) {
                if (chars[j] != ' ' && c == chars[j]) {
                    ans.append(chars[j]);
                    chars[j] = ' ';
                }
                j++;
            }
        }
        for (char c : chars) {
            if (c != ' ') {
                ans.append(c);
            }
        }
        return ans.toString();
    }

}