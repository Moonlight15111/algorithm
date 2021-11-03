package com.moonlight.algorithm.train.cnt;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 你可以假定该字符串只包含小写字母。
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *
 * @author Moonlight
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}