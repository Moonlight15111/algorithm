package com.moonlight.algorithm.train.contest.weeklycontest245;

/**
 * 给你一个字符串数组 words（下标 从 0 开始 计数）。
 * 在一步操作中，需先选出两个 不同 下标 i 和 j，其中 words[i] 是一个非空字符串，
 * 接着将 words[i] 中的 任一 字符移动到 words[j] 中的 任一 位置上。
 * 如果执行任意步操作可以使 words 中的每个字符串都相等，返回 true ；否则，返回 false 。
 *
 * 输入：words = ["abc","aabc","bc"]
 * 输出：true
 * 解释：将 words[1] 中的第一个 'a' 移动到 words[2] 的最前面。
 * 使 words[1] = "abc" 且 words[2] = "abc" 。
 * 所有字符串都等于 "abc" ，所以返回 true 。
 *
 * 输入：words = ["ab","a"]
 * 输出：false
 * 解释：执行操作无法使所有字符串都相等。
 *
 * @ClassName MakeEqual
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/6/13 10:35
 * @Version V1.0
 **/
public class MakeEqual {

    public static void main(String[] args) {
        String[] a = {"abc", "aabc", "bc"},
                b = {"ab", "a"},
                c = {"a", "b"},
                d = {"caaaaa","aaaaaaaaa","a","bbb","bbbbbbbbb","bbb","cc","cccccccccccc","ccccccc","ccccccc","cc","cccc","c","cccccccc","c"};

        System.out.println(makeEqual(a));
        System.out.println(makeEqual(b));
        System.out.println(makeEqual(c));
        System.out.println(makeEqual(d));
    }

    public static boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }
        int[] help = new int[26];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                help[c - 'a']++;
            }
        }
        for (int i = 0, len =  words.length; i < 26; i++) {
            if (help[i] % len != 0) {
                return false;
            }
        }
        return true;
    }

}
