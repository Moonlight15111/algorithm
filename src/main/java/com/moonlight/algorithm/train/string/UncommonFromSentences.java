package com.moonlight.algorithm.train.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/uncommon-words-from-two-sentences/
 *
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 *
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"  输出：["sweet","sour"]
 *
 * 输入：s1 = "apple apple", s2 = "banana"  输出：["banana"]
 *
 * @ClassName UncommonFromSentences
 * @Description: TODO
 * @Author Moonlight
 * @Date 2022/1/1 13:20
 * @Version V1.0
 **/
public class UncommonFromSentences {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet", "this apple is sour")));
        System.out.println(Arrays.toString(uncommonFromSentences("apple apple", "banana")));
    }

    public static String[] uncommonFromSentences(String s1, String s2) {
        String[] a = s1.split(" "), b = s2.split(" ");
        Map<String, Integer> cnt = new HashMap<>();
        for (String s : a) {
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        for (String s : b) {
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
        }
        List<Map.Entry<String, Integer>> collect = cnt.entrySet().stream().filter(e -> e.getValue() == 1).collect(Collectors.toList());
        String[] ans = new String[collect.size()];
        int i = 0;
        for (Map.Entry<String, Integer> e : collect) {
            ans[i++] = e.getKey();
        }
        return ans;
    }

}
