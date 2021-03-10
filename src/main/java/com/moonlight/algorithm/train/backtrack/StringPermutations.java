package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *
 * @author Moonlight
 * @date 2021/3/10 15:04
 */
public class StringPermutations {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
        System.out.println(Arrays.toString(permutation("aab")));
    }

    public static String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        boolean[] visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(new StringBuilder(), visited, chars, res);
        return res.toArray(new String[res.size()]);
    }

    public static void backtrack(StringBuilder builder, boolean[] visited, char[] source, List<String> res) {
        if (builder.length() == source.length) {
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < source.length; i++) {
            if (!visited[i]) {
                if (i > 0 && source[i] == source[i - 1] && !visited[i - 1]) {
                    continue;
                }
                builder.append(source[i]);
                visited[i] = true;
                backtrack(builder, visited, source, res);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }

}
