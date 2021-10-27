package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/
 *
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 * 输入：s = "()())()"  输出：["(())()","()()()"]
 *
 * 输入：s = "(a)())()"  输出：["(a())()","(a)()()"]
 *
 * 输入：s = ")("  输出：[""]
 *
 * @author Moonlight
 */
public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        System.out.println(removeInvalidParentheses("()())()"));
        System.out.println(removeInvalidParentheses("(a)())()"));
        System.out.println(removeInvalidParentheses(")("));
    }

    public static List<String> removeInvalidParentheses(String s) {
        // 对于每个(或者)我们都可以选或者不选，不过不管选不选，只有当字符串中的左右括号数量一致时，才可以入选答案
        // 又因为删除最小数量的无效括号，所以应该选取最长的结果
        Set<String> ans = new HashSet<>();

        backtrack(0, 0, 0, new StringBuilder(), s, ans);

        final int maxLen = ans.stream().mapToInt(String::length).max().getAsInt();

        ans.removeIf(item -> item.length() < maxLen);

        return new ArrayList<>(ans);
    }

    private static void backtrack(int i, int leftCnt, int rightCnt, StringBuilder path, String s, Set<String> ans) {
        if (rightCnt > leftCnt) {
            return;
        }
        if (i == s.length()) {
            if (leftCnt == rightCnt) {
                ans.add(path.toString());
            }
            return;
        }

        if (s.charAt(i) == '(') {
            // 不选当前(
            backtrack(i + 1, leftCnt, rightCnt, path, s, ans);
            // 选当前(
            backtrack(i + 1, leftCnt + 1, rightCnt, path.append(s.charAt(i)), s, ans);
        } else if (s.charAt(i) == ')') {
            // 不选当前)
            backtrack(i + 1, leftCnt, rightCnt, path, s, ans);
            // 选当前)
            backtrack(i + 1, leftCnt, rightCnt + 1, path.append(s.charAt(i)), s, ans);
        } else {
            backtrack(i + 1, leftCnt, rightCnt, path.append(s.charAt(i)), s, ans);
        }
        path.deleteCharAt(path.length() - 1);
    }
}