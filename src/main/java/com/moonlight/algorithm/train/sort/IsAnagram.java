package com.moonlight.algorithm.train.sort;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * 输入: s = "anagram", t = "nagaram"  输出: true
 *
 * 输入: s = "rat", t = "car"  输出: false
 *
 * @ClassName IsAnagram
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/23 13:58
 * @Version V1.0
 **/
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        int[] a = new int[26], b = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            b[c - 'a']++;
        }
        return Arrays.equals(a, b);
    }

}
