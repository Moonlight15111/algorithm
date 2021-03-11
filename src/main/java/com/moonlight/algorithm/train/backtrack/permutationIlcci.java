package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/permutation-i-lcci/
 *
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 *  输入：S = "qwe"    输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 *  输入：S = "ab"    输出：["ab", "ba"]
 *
 * @author Moonlight
 * @date 2021/3/11 18:13
 */
public class permutationIlcci {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("qwe")));
        System.out.println(Arrays.toString(permutation("ab")));
    }

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        backtrack(new StringBuilder(), s.toCharArray(), visited, list);
        return list.toArray(new String[list.size()]);
    }

    private static void backtrack(StringBuilder builder, char[] chars, boolean[] visited, List<String> list) {
        if (builder.length() == chars.length) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            if (!visited[i]) {
                builder.append(chars[i]);
                visited[i] = true;
                backtrack(builder, chars, visited, list);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }

}
