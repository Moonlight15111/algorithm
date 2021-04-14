package com.moonlight.algorithm.train.sort;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * <p>
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 输入: "tree"  输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * <p>
 * 输入: "cccaaa"  输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * <p>
 * 输入: "Aabb"   输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。注意'A'和'a'被认为是两种不同的字符。
 *
 * @author Moonlight
 * @date 2021/4/14 13:06
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
        queue.addAll(map.keySet());
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            int count = map.get(poll);
            for (int i = 0; i < count; i++) {
                builder.append(poll);
            }
        }
        return builder.toString();
    }

}
