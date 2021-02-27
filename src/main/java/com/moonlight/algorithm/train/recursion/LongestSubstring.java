package com.moonlight.algorithm.train.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * 原题：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 *
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 * 输入：s = "aaabb", k = 3  输出：3   解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 *
 * 输入：s = "ababbc", k = 2  输出：5  解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * @ClassName LongestSubstring
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/27 15:06
 * @Version V1.0
 **/
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
        System.out.println(longestSubstring("ababbc", 2));
    }

    public static int longestSubstring(String s, int k) {
        if (s == null || k > s.length() ) {
            return 0;
        }
        // 如果某个字符 x 在 s 中出现的总次数小于K，那么我们就应该跳过这个字符
        // 所以我们把 s 按 x 进行分割，这样子就可以得到很多个不包含 x 的子串
        // 把子串继续上述过程 取Max    其实就是消除出现次数小于k的字符
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : map.keySet()) {
            if (map.get(c) < k) {
                int res = 0;
                for (String sub : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring(sub, k));
                }
                return res;
            }
        }

        return s.length();
    }
}
