package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 *
 * 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
 * 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
 *
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母。
 *
 * 输入：s = "abacbc"  输出：true
 * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
 *
 * 输入：s = "aaabb"  输出：false
 * 解释：s 中出现过的字符为 'a' 和 'b' 。
 * 'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
 *
 * @author Moonlight
 */
public class AreOccurrencesEqual {

    public static void main(String[] args) {
        System.out.println(areOccurrencesEqual("abacbc"));
        System.out.println(areOccurrencesEqual("aaabb"));
    }

    public static boolean areOccurrencesEqual(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int n = 0;
        for (int c : cnt) {
            if (c > 0) {
                if (n != 0 && c != n) {
                    return false;
                }
                n = c;
            }
        }
        return true;
    }

}
