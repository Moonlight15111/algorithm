package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/check-whether-two-strings-are-almost-equivalent/
 *
 * 如果两个字符串 word1 和 word2 中从 'a' 到 'z' 每一个字母出现频率之差都 不超过 3 ，那么我们称这两个字符串 word1 和 word2 几乎相等 。
 * 给你两个长度都为 n 的字符串 word1 和 word2 ，如果 word1 和 word2 几乎相等 ，请你返回 true ，否则返回 false 。
 * 一个字母 x 的出现 频率 指的是它在字符串中出现的次数。
 *
 * n == word1.length == word2.length
 * 1 <= n <= 100
 * word1 和 word2 都只包含小写英文字母。
 *
 * 输入：word1 = "aaaa", word2 = "bccb"  输出：false
 * 解释：字符串 "aaaa" 中有 4 个 'a' ，但是 "bccb" 中有 0 个 'a' 。 两者之差为 4 ，大于上限 3 。
 *
 * 输入：word1 = "abcdeef", word2 = "abaaacc"  输出：true
 *
 * 输入：word1 = "cccddabba", word2 = "babababab"  输出：true
 *
 * @ClassName CheckAlmostEquivalent
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/12/4 13:09
 * @Version V1.0
 **/
public class CheckAlmostEquivalent {

    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(checkAlmostEquivalent("cccddabba", "babababab"));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        if (word1.length() < 4 || word2.length() < 4) {
            return true;
        }
        int[] wa = new int[26], wb = new int[26];
        for (char c : word1.toCharArray()) {
            wa[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            wb[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (Math.abs(wa[i] - wb[i]) > 3) {
                return false;
            }
        }
        return true;
    }

}
