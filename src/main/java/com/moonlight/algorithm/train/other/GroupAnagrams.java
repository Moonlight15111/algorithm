package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 所有输入均为小写字母。不考虑答案输出的顺序。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * @author Moonlight
 * @date 2021/3/25 11:13
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"},
                b = {"ac", "c"},
                d = {"ddddddddddg", "dgggggggggg"};
        System.out.println(groupAnagrams(a));
        System.out.println(groupAnagrams(b));
        System.out.println(groupAnagrams(d));

        System.out.println(groupAnagrams12313(a));
        System.out.println(groupAnagrams12313(b));
        System.out.println(groupAnagrams12313(d));
    }

    public static List<List<String>> groupAnagrams12313(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();

        List<String> tmp;
        String s;
        char[] chars;
        for (String str : strs) {
            chars = str.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);
            tmp = map.getOrDefault(s, new ArrayList<String>());
            tmp.add(str);
            map.put(s, tmp);
        }
        res.addAll(map.values());
        return res;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs != null && strs.length > 0) {
            int length = strs.length;
            boolean[] visited = new boolean[length];
            List<String> tmp;
            for (int i = 0; i < length; i++) {
                if (!visited[i]) {
                    tmp = new ArrayList<>();
                    visited[i] = true;
                    tmp.add(strs[i]);
                    for (int j = 0; j < length; j++) {
                        if (!visited[j] && match(strs[i], strs[j])) {
                            visited[j] = true;
                            tmp.add(strs[j]);
                        }
                    }
                    res.add(tmp);
                }
            }
        }
        return res;
    }

    private static boolean match(String str, String str1) {
        if (str.length() != str1.length()) {
            return false;
        }
        int[] a = new int[26];
        for (char c : str.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : str1.toCharArray()) {
            if (a[c - 'a'] <= 0) {
                return false;
            }
            a[c - 'a']--;
        }
        return true;
    }

}
