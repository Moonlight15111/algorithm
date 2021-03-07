package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射与手机九键按键相同。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author Moonlight
 * @date 2021/1/5 18:09
 */
public class LetterCombinations {

    public static void main(String[] args) {
        for (String str : letterCombinations("23")) {
            System.out.print(str + ", ");
        }
        System.out.println();
        for (String str : letterCombinations222("23")) {
            System.out.print(str + ", ");
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        process(digits.toCharArray(), 0, "", res, map);

        return res;
    }

    private static void process(char[] chars, int index, String path, List<String> res, Map<Character, String> mapping) {
        if (index == chars.length) {
            res.add(path);
            return;
        }
        String s = mapping.get(chars[index]);
        if (s == null || s.length() == 0) {
            return;
        }
        for (int i = 0, len = s.length(); i < len; i++) {
            process(chars, index + 1, path + s.charAt(i), res, mapping);
        }
    }

    public static List<String> letterCombinations222(String digits) {
        // 回溯快了5ms
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer("");
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(digits.toCharArray(), 0, sb, res, map);
        return res;
    }

    private static void backtrack(char[] chars, int index, StringBuffer path, List<String> res, Map<Character, String> mapping) {
        if (index == chars.length) {
            res.add(path.toString());
            return;
        }
        String s = mapping.get(chars[index]);
        if (s == null || s.length() == 0) {
            return;
        }
        for (char c : s.toCharArray()) {
            path.append(c);
            backtrack(chars, index + 1, path, res, mapping);
            path.deleteCharAt(path.length() - 1);
        }
    }

}
