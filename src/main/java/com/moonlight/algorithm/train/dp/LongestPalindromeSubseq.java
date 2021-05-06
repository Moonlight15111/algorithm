package com.moonlight.algorithm.train.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 *
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * 输入: "bbbab"  输出: 4
 * 解释: 一个可能的最长回文子序列为 "bbbb"。
 *
 * 输入: "cbbd"  输出: 2
 * 解释: 一个可能的最长回文子序列为 "bb"。
 *
 * @author Moonlight
 * @date 2021/5/6 12:51
 */
public class LongestPalindromeSubseq {

    public static void main(String[] args) {
        System.out.println(recursion("bbbab") + ", " + memory("bbbab") + ", " + dp("bbbab"));
        System.out.println(recursion("cbbd") + ", " + memory("cbbd") + ", " + dp("cbbd"));

        String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        System.out.println(dp(s));
    }

    public static int dp(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // n - j 就相当于从后往前遍历，所以就是[0, (n - 1)]
                if (s.charAt(i - 1) == s.charAt(n - j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public static int memory(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        return memory(s, 0, new StringBuilder(), map);
    }

    private static int memory(String s, int i, StringBuilder path, Map<Integer, Map<String, Integer>> map) {
        if (map.containsKey(i)) {
            if (map.get(i).containsKey(path.toString())) {
                return map.get(i).get(path.toString());
            }
        }
        if (i == s.length()) {
            Map<String, Integer> orDefault = map.getOrDefault(i, new HashMap<>());
            orDefault.put(path.toString(), isPalindrome(path.toString()) ? path.length() : 0);
            return orDefault.get(path.toString());
        }
        int p = memory(s, i + 1, path, map);

        Map<String, Integer> orDefault = map.getOrDefault(i, new HashMap<>());
        orDefault.put(path.toString(), p);

        path.append(s.charAt(i));
        int ap = memory(s, i + 1, path, map);

        orDefault = map.getOrDefault(i, new HashMap<>());
        orDefault.put(path.toString(), ap);

        path.deleteCharAt(path.length() - 1);

        orDefault = map.getOrDefault(i, new HashMap<>());
        orDefault.put(path.toString(), Math.max(p, ap));

        return Math.max(p, ap);
    }

    public static int recursion(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        return recursion(s, 0, new StringBuilder());
    }

    private static int recursion(String s, int i, StringBuilder path) {
        if (i == s.length()) {
            return isPalindrome(path.toString()) ? path.length() : 0;
        }
        int p = recursion(s, i + 1, path);
        path.append(s.charAt(i));
        int ap = recursion(s, i + 1, path);
        path.deleteCharAt(path.length() - 1);
        return Math.max(p, ap);
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int leftPtr = 0, rightPtr = s.length() - 1;
        while (leftPtr <= rightPtr) {
            if (s.charAt(leftPtr) != s.charAt(rightPtr)) {
                return false;
            }
            leftPtr++;
            rightPtr--;
        }
        return true;
    }

}
