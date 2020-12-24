package com.moonlight.algorithm.train.bitManipulation;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/number-of-good-ways-to-split-a-string/
 * 给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数目相同。
 * 请你返回 s 中好分割的数目。
 *
 * 输入：s = "aacaba"
 * 输出：2
 * 解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
 * ("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
 * ("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
 * ("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
 *
 * @author Moonlight
 * @date 2020/12/24 11:43
 */
public class NumSplitsString {

    public static void main(String[] args) {
        System.out.println(numSplits("aacaba") + "===========" + numSplits222222("aacaba"));
        System.out.println(numSplits("abcd") + "===========" + numSplits222222("abcd"));
        System.out.println(numSplits("aaaaa") + "===========" + numSplits222222("aaaaa"));
        System.out.println(numSplits("acbadbaada") + "===========" + numSplits222222("acbadbaada"));
    }

    public static int numSplits33333(String s) {
        return 0;
    }

    public static int numSplits222222(String s) {
        // 用Map记录从左往右 和 从右往左 每个字符出现的次数
        // 时间空间都不太好 勉强能过
        Map<Character, Integer> left = new HashMap<>();
        Map<Character, Integer> right = new HashMap<>();
        int count = 0;

        char[] chars = s.toCharArray();
        for (char c : chars) {
            left.put(c, left.getOrDefault(c, 0) + 1);
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            right.put(chars[i], right.getOrDefault(chars[i], 0) + 1);
            if (left.containsKey(chars[i])) {
                left.put(chars[i], left.get(chars[i]) - 1);
                if (left.get(chars[i]) == 0) {
                    left.remove(chars[i]);
                }
            }
            if (left.size() == right.size()) {
                count++;
            }
        }

        return count;
    }

    public static int numSplits(String s) {
        // 暴力破解  超时
        int count = 0;
        String subStr1, subStr2;
        for (int i = 0, len = s.length(); i < len; i++) {
            subStr1 = s.substring(0, i);
            subStr2 = s.substring(i, len);
            if (diffLettersCount(subStr1) == diffLettersCount(subStr2)) {
                count++;
            }
        }
        return count;
    }

    public static int diffLettersCount(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }

}
