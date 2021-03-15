package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/letter-tile-possibilities/
 *
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * 注意：本题中，每个活字字模只能使用一次。
 *
 * 输入："AAB"   输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 *
 * 输入："AAABBC"  输出：188
 *
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 *
 * @author Moonlight
 * @date 2021/3/15 18:04
 */
public class LetterTilePossibilities {

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB") + ", " + num("AAB"));
        System.out.println(numTilePossibilities("AAABBC") + ", " + num("AAABBC"));
        System.out.println(numTilePossibilities("CDC") + ", " + num("CDC"));
    }

    public static int num(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[tiles.length()];
        return backtrack(new StringBuilder(), visited, chars);
    }

    private static int backtrack(StringBuilder builder, boolean[] visited, char[] chars) {
        int res = 0;
        if (builder.length() > 0) {
            res++;
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            if (!visited[i]) {
                if (i > 0 && chars[i - 1] == chars[i] && !visited[i - 1]) {
                    continue;
                }
                builder.append(chars[i]);
                visited[i] = true;
                res += backtrack(builder, visited, chars);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
        return res;
    }

    public static int numTilePossibilities(String tiles) {
        if (tiles == null || tiles.length() == 0) {
            return 0;
        }
        char[] chars = tiles.toCharArray();
        Arrays.sort(chars);
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[tiles.length()];
        backtrack(new StringBuilder(), visited, chars, res);
        System.out.println(res);
        return res.size();
    }

    private static void backtrack(StringBuilder builder, boolean[] visited, char[] chars, List<String> res) {
        if (builder.length() > 0) {
            res.add(builder.toString());
        }
        for (int i = 0, len = chars.length; i < len; i++) {
            if (!visited[i]) {
                if (i > 0 && chars[i - 1] == chars[i] && !visited[i - 1]) {
                    continue;
                }
                builder.append(chars[i]);
                visited[i] = true;
                backtrack(builder, visited, chars, res);
                builder.deleteCharAt(builder.length() - 1);
                visited[i] = false;
            }
        }
    }

}
