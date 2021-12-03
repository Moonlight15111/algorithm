package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"  输出: true
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"  输出: false
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"  输出: false
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"  输出: false
 *
 * @author Moonlight
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        if (split.length != pattern.length()) {
            return false;
        }
        Map<String, Character> str = new HashMap<>();
        Map<Character, String> cha = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            if (str.get(split[i]) != null && str.get(split[i]) != pattern.charAt(i)) {
                return false;
            }
            if (cha.get(pattern.charAt(i)) != null && !cha.get(pattern.charAt(i)).equals(split[i])) {
                return false;
            }
            str.put(split[i], pattern.charAt(i));
            cha.put(pattern.charAt(i), split[i]);
        }
        return true;
    }

}