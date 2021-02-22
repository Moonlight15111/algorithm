package com.moonlight.algorithm.train.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
/**
 * 原题: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"   输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"      输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"     输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 输入: s = ""    输出: 0
 *
 * @ClassName LengthOfLongestSubstring
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/2/22 22:54
 * @Version V1.0
 **/
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("sabkescdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = Integer.MIN_VALUE, leftPtr = 0, rightPtr = 0, length = chars.length;

        Map<Character, Integer> map = new HashMap<>();

        while (rightPtr < length) {
            res = Math.max(res, rightPtr - leftPtr);

            if (map.containsKey(chars[rightPtr]) && map.get(chars[rightPtr]) >= leftPtr) {
                leftPtr = map.get(chars[rightPtr]) + 1;
            }
            map.put(chars[rightPtr], rightPtr);
            rightPtr++;
        }
        res = Math.max(res, rightPtr - leftPtr);
        return res;
    }

}
