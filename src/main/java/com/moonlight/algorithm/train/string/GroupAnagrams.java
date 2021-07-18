package com.moonlight.algorithm.train.string;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams-lcci/
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *  所有输入均为小写字母。
 *  不考虑答案输出的顺序。
 *
 * @ClassName GroupAnagrams
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/7/18 12:19
 * @Version V1.0
 **/
public class GroupAnagrams {

    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(s);
        for (List<String> list : lists){
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        char[] chars;
        List<String> list;
        String sort;
        for (String s : strs) {
            chars = s.toCharArray();
            Arrays.sort(chars);
            sort = new String(chars);
            list = map.getOrDefault(sort, new ArrayList<>());
            list.add(s);
            map.put(sort, list);
        }
        return new ArrayList<>(map.values());
    }

}
