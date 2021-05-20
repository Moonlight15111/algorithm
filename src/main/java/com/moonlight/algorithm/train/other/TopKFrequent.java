package com.moonlight.algorithm.train.other;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 * <p>
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。
 * 如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2    输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 *
 * @author Moonlight
 * @date 2021/5/20 13:26
 */
public class TopKFrequent {

    public static void main(String[] args) {
        String[] a = {"i", "love", "leetcode", "i", "love", "coding"},
                b = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                c = {"aaa", "aa", "a"};
        System.out.println(topKFrequent(a, 2));
        System.out.println(topKFrequent(b, 4));
        System.out.println(topKFrequent(c, 1));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (!ans.contains(s)) {
                ans.add(s);
            }
        }

        ans.sort((a, b) -> Objects.equals(map.get(a), map.get(b)) ? a.compareTo(b) : map.get(b) - map.get(a));

        return ans.subList(0, k);
    }

}
