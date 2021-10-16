package com.moonlight.algorithm.train.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/expression-add-operators/
 *
 * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，
 * 在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 *
 * 输入: num = "123", target = 6  输出: ["1+2+3", "1*2*3"]
 *
 * 输入: num = "232", target = 8  输出: ["2*3+2", "2+3*2"]
 *
 * 输入: num = "105", target = 5  输出: ["1*0+5","10-5"]
 *
 * 输入: num = "00", target = 0  输出: ["0+0", "0-0", "0*0"]
 *
 * 输入: num = "3456237490", target = 9191  输出: []
 *
 * @ClassName AddOperators
 * @Description: TODO
 * @Author Moonlight
 * @Date 2021/10/16 13:37
 * @Version V1.0
 **/
public class AddOperators {

    public static void main(String[] args) {
        System.out.println(addOperators("123", 6));
        System.out.println(addOperators("232", 8));
        System.out.println(addOperators("105", 5));
        System.out.println(addOperators("00", 0));
        System.out.println(addOperators("3456237490", 9191));
    }

    public static List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }
        backtrack(0, new StringBuilder(), 0L,  0L, target, num, ans);
        return ans;
    }

    private static void backtrack(int i, StringBuilder path, long s, long p, int target, String num, List<String> ans) {
        if (i == num.length()) {
            if (s == target && !ans.contains(path.toString())) {
                ans.add(path.toString());
            }
            return;
        }
        for (int j = i; j < num.length(); j++) {
            String substring = num.substring(i, j + 1);
            if (substring.charAt(0) == '0' && substring.length() > 1) {
                continue;
            }
            long curVal = Long.parseLong(substring);
            if (i == 0) {
                path.append(substring);
                backtrack(j + 1, path, s + curVal, curVal, target, num, ans);
                path.delete(path.length() - (j - i + 1), path.length());
            } else {
                path.append("+").append(substring);
                backtrack(j + 1, path, s + curVal, curVal, target, num, ans);
                path.delete(path.length() - (j - i + 1) - 1, path.length());

                path.append("-").append(substring);
                backtrack(j + 1, path, s - curVal, -curVal, target, num, ans);
                path.delete(path.length() - (j - i + 1) - 1, path.length());

                path.append("*").append(substring);
                backtrack(j + 1, path, s - p + p * curVal, p * curVal, target, num, ans);
                path.delete(path.length() - (j - i + 1) - 1, path.length());
            }
        }
    }

}
