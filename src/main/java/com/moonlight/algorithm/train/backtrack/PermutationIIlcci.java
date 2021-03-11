package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/permutation-ii-lcci/
 *
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 *  输入：S = "qqe"   输出：["eqq","qeq","qqe"]
 *
 *   输入：S = "ab"    输出：["ab", "ba"]
 *
 * @author Moonlight
 * @date 2021/3/11 17:51
 */
public class PermutationIIlcci {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("qqe")));
        System.out.println(Arrays.toString(permutation("ab")));
    }

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        backtrack( new StringBuilder(), visited, chars, list);
        return list.toArray(new String[list.size()]);
    }

    private static void backtrack(StringBuilder builder, boolean[] visited, char[] chars, List<String> list) {
        if (builder.length() == chars.length) {
            list.add(builder.toString());
            return;
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            if (!visited[i]) {
                if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
                    continue;
                }
                builder.append(chars[i]);
                visited[i] = true;
                backtrack(builder, visited, chars, list);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }
}
