package com.moonlight.algorithm.train.bitManipulation;

import java.util.*;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 *
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4
 *
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 *
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * @author Moonlight
 * @date 2020/12/22 11:51
 */
public class MaximumLength0fAConcatenatedString {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("un");
        list.add("iq");
        list.add("ue");

        List<String> list222 = new ArrayList<>();
        list222.add("cha");
        list222.add("r");
        list222.add("act");
        list222.add("ers");

        List<String> list3333 = new ArrayList<>();
        list3333.add("abcdefghijklmnopqrstuvwxyz");

        String[] ss = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
        List<String> list444 = new ArrayList<>();
        list444.addAll(Arrays.asList(ss));

        System.out.println(maxLength(list));
        System.out.println(maxLength(list222));
        System.out.println(maxLength(list3333));
        System.out.println(maxLength(list444));
    }

    public static int maxLength(List<String> arr) {
        // remind: 写不出来，题解也看不明白，可能对题目的理解出现了问题，留着以后脑子清醒了写
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        return 1;
        // 判断子串本身是否有相同字符
        // 判断 第 i 个子串 和 第 i + 1 个子串是否有相同字符
        // 如果没有相同字符，则相连，并假定这就是最长长度，记录为 maxLen
        // 循环上述过程
//        int maxLen = 0;
//
//        StringBuilder temp;
//        for (int i = 0, size = arr.size(); i < size; i++) {
//            if (dupCheck(arr.get(i))) {
//                continue;
//            }
//            temp = new StringBuilder(arr.get(i));
//            for (int j = i + 1; j < size; j++) {
//                if (dupCheck(arr.get(j)) || dupCheck(temp.toString() + arr.get(j))) {
//                    continue;
//                }
//                temp.append(arr.get(j));
//                maxLen = Math.max(temp.length(), maxLen);
//            }
//        }
//
//        return maxLen;
    }

    private static boolean dupCheck(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() != s.toCharArray().length;
    }

}
