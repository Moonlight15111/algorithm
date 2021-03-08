package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题: https://leetcode-cn.com/problems/palindrome-partitioning-ii/
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 *
 * 输入：s = "aab"   输出：1   解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 *
 * 输入：s = "a"     输出：0
 *
 * 输入：s = "ab"    输出：1
 *
 * @author Moonlight
 * @date 2021/3/8 9:17
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(minCut("aab") + ", " + minCut123("aab"));
    }

    public static int minCut123(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        // 预处理—visited[i][j]表示[i, j]是否为回文串
        boolean[][] visited = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || visited[j + 1][i - 1])) {
                    visited[j][i] = true;
                }
            }
        }
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i++) {
            if (visited[0][i]) {
                dp[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (visited[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[len - 1];
    }

    public static int minCut(String s) {
        // 超时
        if (s == null || s.length() < 2) {
            return 0;
        }
        boolean[][] visited = new boolean[s.length()][s.length()];
        return backtrack(0, s, new ArrayList<>(), s.length(), visited);
    }

    private static int backtrack(int index, String source, ArrayList<String> path, int res, boolean[][] visited) {
        if (index == source.length()) {
            return Math.min(path.size() - 1, res);
        }
        String sub;
        for (int i = index; i < source.length(); i++) {
            sub = source.substring(index, i + 1);
            if (isPalindrome(sub) && !visited[index][i]) {
                path.add(sub);
                visited[index][i] = true;
                res = Math.min(backtrack(i + 1, source, path, res, visited), res);
                path.remove(path.size() - 1);
                visited[index][i] = false;
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
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
