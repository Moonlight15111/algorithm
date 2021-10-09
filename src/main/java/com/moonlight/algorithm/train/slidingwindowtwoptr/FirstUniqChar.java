package com.moonlight.algorithm.train.slidingwindowtwoptr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 输入：s = "abaccdeff"  输出：'b'
 *
 * 输入：s = ""  输出：' '
 *
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("abaccdeff") + ", " + doublePtr("abaccdeff"));
        System.out.println(firstUniqChar("") + ", " + doublePtr(""));
    }

    public static char doublePtr(String s) {
        int l, r, len = s.length();
        for (int i = 0; i < len; i++) {
            l = 0;
            r = len - 1;
            while (l < r && s.charAt(l) != s.charAt(i)) {
                l++;
            }
            while (l < r && s.charAt(r) != s.charAt(i)) {
                r--;
            }
            if (l == r) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static char firstUniqChar(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
            if (!m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), i);
            }
        }
        char ans = ' ';
        int p = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 1 && m.containsKey((char) (i + 'a')) && m.get((char) (i + 'a')) < p) {
                ans = (char) (i + 'a');
                p = m.get(ans);
            }
        }
        return ans;
    }

}