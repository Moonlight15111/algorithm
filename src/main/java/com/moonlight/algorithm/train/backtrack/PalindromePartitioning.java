package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 原题：https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回 s 所有可能的分割方案。
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * @ClassName PalindromePartitioning
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/3/7 12:54
 * @Version V1.0
 **/
public class PalindromePartitioning {

    public static void main(String[] args) {
        System.out.println(partition("aab").toString());
    }

    public static List<List<String>> partition(String s) {
        // 套回溯模板套出来的
        List<List<String>> res = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return res;
        }

        backtrack(0, s, new ArrayList<>(), res);

        return res;
    }

    public static void backtrack(int index, String source, List<String> tmp, List<List<String>> res) {
        if (index == source.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index, len = source.length(); i < len; i++) {
            String substring = source.substring(index, i + 1);
            if (isPalindrome(substring)) {
                tmp.add(substring);
                backtrack(i + 1, source, tmp, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
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
