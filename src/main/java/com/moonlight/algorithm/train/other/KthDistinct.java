package com.moonlight.algorithm.train.other;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/kth-distinct-string-in-an-array/
 *
 * 独一无二的字符串 指的是在一个数组中只出现过 一次 的字符串。
 * 给你一个字符串数组 arr 和一个整数 k ，请你返回 arr 中第 k 个 独一无二的字符串 。
 * 如果 少于 k 个独一无二的字符串，那么返回 空字符串 "" 。
 * 注意，按照字符串在原数组中的 顺序 找到第 k 个独一无二字符串。
 *
 * 1 <= k <= arr.length <= 1000
 * 1 <= arr[i].length <= 5
 * arr[i] 只包含小写英文字母。
 *
 * 输入：arr = ["d","b","c","b","c","a"], k = 2  输出："a"
 * 解释：arr 中独一无二字符串包括 "d" 和 "a" 。
 *      "d" 首先出现，所以它是第 1 个独一无二字符串。
 *      "a" 第二个出现，所以它是 2 个独一无二字符串。
 *      由于 k == 2 ，返回 "a" 。
 *
 * 输入：arr = ["aaa","aa","a"], k = 1  输出："aaa"
 * 解释：arr 中所有字符串都是独一无二的，所以返回第 1 个字符串 "aaa" 。
 *
 * 输入：arr = ["a","b","a"], k = 3  输出：""
 * 解释：唯一一个独一无二字符串是 "b" 。由于少于 3 个独一无二字符串，我们返回空字符串 "" 。
 *
 * @author Moonlight
 */
public class KthDistinct {

    public static void main(String[] args) {
        String[] a = {"d", "b", "c", "b", "c", "a"},
                 b = {"aaa", "aa", "a"},
                 c = {"a", "b", "a"};
        System.out.println(kthDistinct(a, 2));
        System.out.println(kthDistinct(b, 1));
        System.out.println(kthDistinct(c, 3));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int i = 0;
        for (String s : arr) {
            if (map.get(s) == 1) {
                i++;
            }
            if (i == k) {
                return s;
            }
        }
        return "";
    }

}
