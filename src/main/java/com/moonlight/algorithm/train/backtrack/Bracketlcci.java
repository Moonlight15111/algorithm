package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈功能简述〉<br>
 * 〈〉
 * 原题：https://leetcode-cn.com/problems/bracket-lcci/
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 *
 * @author Moonlight
 * @date 2021/3/10 12:23
 */
public class Bracketlcci {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add("()");
            return res;
        }
        backtrack(n, n, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(int left, int right, StringBuilder str, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str.toString());
//            return;
        } else if (left == right) {
            backtrack(left - 1, right, str.append("("), res);
            str.deleteCharAt(str.length() - 1);
        } else if (left < right) {
            if (left > 0) {
                backtrack(left - 1, right, str.append("("), res);
                str.deleteCharAt(str.length() - 1);
            }
            backtrack(left, right - 1, str.append(")"), res);
            str.deleteCharAt(str.length() - 1);
        }
//        if (left > 0) {
//            left--;
//            str.append("(");
//            backtrack(left, right, str, res);
//            str.deleteCharAt(str.length() - 1);
//            left++;
//        }
//        if (right > left) {
//            right--;
//            str.append(")");
//            backtrack(left, right, str, res);
//            str.deleteCharAt(str.length() - 1);
//        }
    }
}
